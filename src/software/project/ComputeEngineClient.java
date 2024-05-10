package software.project;
import java.util.concurrent.TimeUnit;

import compute_engine.ComputeEngine;
import compute_engine.ComputeServiceGrpc;
import compute_engine.ComputeServiceGrpc.ComputeServiceBlockingStub;
import compute_engine.ComputeEngine.ComputeRequest;
import compute_engine.ComputeEngine.ComputeResponse;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

import static compute_engine.ComputeServiceGrpc.newBlockingStub;
public class ComputeEngineClient { // Boilerplate TODO: change to <servicename>Client
    private final ComputeServiceBlockingStub blockingStub; // Boilerplate TODO: update to appropriate blocking stub
    private Integer digit;
    private Integer upperLimit;

    public ComputeEngineClient(Channel channel) {
        blockingStub = newBlockingStub(channel);  // Boilerplate TODO: update to appropriate blocking stub
    }

    // Boilerplate TODO: replace this method with actual client call/response logic
    public ComputeResponse compute(String inputPath, String outputPath, String delimiter, Integer digit) {

        ComputeRequest request = ComputeRequest.newBuilder().setDelimeter(delimiter).setDigit(digit)
                .setInputFilePath(inputPath)
                .setOutputFilePath(outputPath)
                .build();
        ComputeEngine.ComputeResponse response;

        response = blockingStub.compute(request);


        return response;


    }

}
