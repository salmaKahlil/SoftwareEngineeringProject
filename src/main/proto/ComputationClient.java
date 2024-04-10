// package main.proto;
// import java.util.concurrent.TimeUnit;

// import io.grpc.Channel;
// import io.grpc.Grpc;
// import io.grpc.InsecureChannelCredentials;
// import io.grpc.ManagedChannel;
// import io.grpc.StatusRuntimeException;
// import phoneservice.PhoneOrderServiceGrpc.PhoneOrderServiceBlockingStub;
// import phoneservice.PhoneService.PhoneOrderRequest;
// import phoneservice.PhoneService.PhoneOrderResponse;

// public class ComputationClient {
//     private final PhoneOrderServiceBlockingStub blockingStub;

//     public PhoneOrderClient(Channel channel) {
//         blockingStub = PhoneOrderServiceGrpc.newBlockingStub(channel);
//     }

//     public void order(int digit, int upperLimit) {
//         ComputeRequest request = ComputeRequest.newBuilder().setValue(digit).build();
//         ComputeResponse response;
//         try {
//             response = blockingStub.compute(request);
//         } catch (StatusRuntimeException e) {
//             return;
//         }
//         // Handle response
//         System.out.println("Result: " + response.getResult());
//     }

//     public static void main(String[] args) throws Exception {
//         String target = "localhost:50051";

//         ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
//                 .build();
//         try {
//             PhoneOrderClient client = new PhoneOrderClient(channel);
//             client.order(5, 10); // Example inputs
//         } finally {
//             channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
//         }
//     }
// }
