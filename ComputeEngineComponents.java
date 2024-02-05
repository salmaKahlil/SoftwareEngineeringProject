// //Prototype the Use Case
//     public void initiateComputation(transferRespose dataTransfered) {
//         // Create a compuation request 
//         ComputationRequest computationRequest = new ComputationRequest(dataTransfered.getData());

//         // Perform the actual computation
//         ComputationResponse computationResponse = computeEngine.performComputation(computationRequest);
//     }
    //Wrapper Interface
    interface computeEngineComponents{
    //types are not determined yet
    //int is not the final type but let it be int for now
        ComputationRequest computationRequest(int data);
        ComputationResponse performComputation(int data);
    }