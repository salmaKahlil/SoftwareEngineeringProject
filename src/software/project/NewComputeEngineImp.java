package software.project;
import java.util.ArrayList;
import java.lang.Math;

public class NewComputeEngineImp {
    public String compute (int digit, int upperLimit)
    {
        int length = (int) (Math.log10 (upperLimit) + 1);
        ArrayList < Integer > upperLimitDigits = new ArrayList <> ();
        int temp = upperLimit;
        for (int i = 0; i < length; i++)
        {
            int num = temp % 10;
            upperLimitDigits.add (num);
            temp = temp / 10;
        }
        int counter = 0;
        for (int i = 0; i < length; i++)
        {
            if (i == 0)
            {
                if (upperLimitDigits.get (i) > digit)
                {
                    counter += 1;
                }
                else if(upperLimitDigits.get(i) == digit){
                    counter += 1;
                }

            }
            else
            {
                counter += upperLimitDigits.get (i) * Math.pow (10, i - 1) * i;
                if (upperLimitDigits.get (i) > digit)
                {
                    counter +=Math.pow(10,i);
                }
                else if(upperLimitDigits.get(i) == digit){
                    counter+= 1 + upperLimit%(Math.pow(10,i));


                }
            }

        }
        return String.valueOf(counter);
    }
}
