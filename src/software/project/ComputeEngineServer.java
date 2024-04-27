//package software.project;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import compute_engine.ComputeEngineGrpc;
//import compute_engine.ComputeEngineOuterClass;
//import io.grpc.Grpc;
//import io.grpc.InsecureServerCredentials;
//import io.grpc.Server;
//import io.grpc.protobuf.services.ProtoReflectionService;
//import io.grpc.stub.StreamObserver;
//
//public class ComputeEngineServer { // Boilerplate TODO: Change name of class
//    private Server server;
//
//    private void start() throws IOException {
//        /* The port on which the server should run */
//        int port = 50051; // Boilerplate TODO: Consider changing the port (only one server per port)
//
//        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
//                .addService(new ComputeEngineGrpc.ComputeEngineImplBase() {
//                    @Override
//                    public void compute(ComputeEngineOuterClass.ComputeRequest request, StreamObserver<ComputeEngineOuterClass.ComputeResponse> responseObserver) {
//                        super.compute(request, responseObserver);
//                    }
//                }) // Boilerplate TODO: Change name of class
//                .addService(ProtoReflectionService.newInstance())
//                .build()
//                .start();
//        System.out.println("Server started on port " + port);
//
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            @Override
//            public void run() {
//                System.err.println("*** shutting down gRPC server since JVM is shutting down");
//                try {
//                    if (server != null) {
//                        server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace(System.err);
//                }
//                System.err.println("*** server shut down");
//            }
//        });
//    }
//
//    /**
//     * Await termination on the main thread since the grpc library uses daemon threads.
//     */
//    private void blockUntilShutdown() throws InterruptedException {
//        if (server != null) {
//            server.awaitTermination();
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        ComputeEngineServer server = new ComputeEngineServer(); // Boilerplate TODO: Change name of class
//        server.start();
//        server.blockUntilShutdown();
//    }
//}
//
