package software.project;
public class ComputeEngineImp implements ComputeEngine {

    public String compute(int digit, int upperLimit){
        
        int counter = 0;
        for(int i = 1; i <= upperLimit; i++ ){ //upperLinit is included within our range
            int temp = i;
            while(temp>0){
                int mode = temp%10;
                temp = temp/10;
                if(mode == digit){
                    counter++;
                }
            } 
        }
        return String.valueOf(counter);
    }
}
