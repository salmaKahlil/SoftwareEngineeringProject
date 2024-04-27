//package software.project;
//
//import java.util.concurrent.TimeUnit;
//
//
//import io.grpc.Channel;
//import io.grpc.Grpc;
//import io.grpc.InsecureChannelCredentials;
//import io.grpc.ManagedChannel;
//import io.grpc.StatusRuntimeException;
//
//
//
//public class ComputeEngineClient { // Boilerplate TODO: change to <servicename>Client
//    private final ComputeEngineGrpc.ComputeEngineBlockingStub blockingStub; // Boilerplate TODO: update to appropriate blocking stub
//
//    public ComputeEngineClient(Channel channel) {
//        blockingStub = ComputeEngineGrpc.newBlockingStub(channel);  // Boilerplate TODO: update to appropriate blocking stub
//    }
//
//    // Boilerplate TODO: replace this method with actual client call/response logic
//    public void compute() {
//        ComputeEngineOuterClass.ComputeRequest request = ComputeEngineOuterClass.ComputeRequest.newBuilder().build();
//        ComputeEngineOuterClass.ComputeResponse response;
//        try {
//            response = blockingStub.compute(request);
//        } catch (StatusRuntimeException e) {
//            return;
//        }
////        if (response.) {
////            System.err.println("Error: " + response.getErrorMessage());
////       } else {
//        System.out.println("Order number: " + response.getResult());
////        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        String target = "localhost:50051";  // Boilerplate TODO: make sure the server/port match the server/port you want to connect to
//
//        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
//                .build();
//        try {
//            ComputeEngineClient client = new ComputeEngineClient(channel); // Boilerplate TODO: update to this class name
//            client.compute();
//        } finally {
//            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
//        }
//    }
//}
