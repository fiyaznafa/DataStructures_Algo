package Strings;

public class GetNonZeroIntegersTest {



    public int[] getNoZeroIntegers(int n) {

        /*
            test data
            1. n=2
            2. n=10
            3. n=31
        */

        /*
            Pseudo code
            1. Get each digit from the number by %10
            2. Subtract the digit by 1
            2. If digit is zero then increase sub value
            3. If digit is negative , the add to carry
            4. Continue till the first digit
        */

        Integer i = 1,temp=n-1;
        while(i.toString().contains("0")||temp.toString().contains("0")){
            i++;
            temp--;
        }

        return new int[] {i,temp};

    }
}
