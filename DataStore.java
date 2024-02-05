// public class api {
//     public void DataRetrieve(DataStore dataStore) {

// 		// retrieve the data from the user api

// 	    dataLoadResponse loadResponse = dataStore.loadData(storeResponse.getDataKey());

// 		//send the data to compute engine

// 		dataTransferResponse transferResponse=dataStore.transferData (loadResponse.getTransferKey());

// 		// receive data back from compute engine and store

// 		dataReceive dataReceive = dataStore.dataReceive(computationResponse.getReceivedKey());

// 		}

interface DataStore {
    //types are not determined yet
    //int is not the final type but let it be int for now
    DataLoadResponse loadData(int key); 

    DataTransferResponse transferData(int key);

    DataReceive dataReceive(int key);
} 

