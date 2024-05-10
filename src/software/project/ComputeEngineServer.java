package software.project;


import compute_engine.ComputeEngine;
import compute_engine.ComputeServiceGrpc;
import compute_engine.ComputeEngine.ComputeRequest;
import compute_engine.ComputeEngine.ComputeResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class ComputeEngineServer {
    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50052;

        server = ServerBuilder.forPort(port)
                .addService(new ComputeServiceImpl())
                .build()
                .start();
        System.out.println("Server started on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                ComputeEngineServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        ComputeEngineServer server = new ComputeEngineServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class ComputeServiceImpl extends ComputeServiceGrpc.ComputeServiceImplBase {
        private final NewComputeEngineImp computeEngine;
        private DataImp ds;
        private SystemCoordinator sc;

        ComputeServiceImpl() {
            this.computeEngine = new NewComputeEngineImp();
            this.ds = new DataImp();

        }

        @Override
        public void compute(ComputeRequest request, StreamObserver<ComputeResponse> responseObserver) {
            sc = new SystemCoordinatorImp(ds, computeEngine);
            IntegersFromTheUser inputConfig = new IntegersFromTheUser(request.getInputFilePath());
            OutputDetails outputConfig = new OutputDetails(request.getOutputFilePath());
            String delimiter = request.getDelimeter();
            Integer digit = request.getDigit();


            ComputeRequestImp internalRequest = new ComputeRequestImp(inputConfig, outputConfig, delimiter, digit);
            ComputeMessage result = sc.runComputeEngine(internalRequest);







            ComputeResponse response = ComputeResponse.newBuilder().setStatusField(ComputeResponse.status.SUCCESS)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
