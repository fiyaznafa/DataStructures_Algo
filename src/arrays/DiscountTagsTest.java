package arrays;

import org.testng.annotations.Test;

public class DiscountTagsTest {

    @Test
    public void test1(){
        int[] val ={2,3,6,-5,10,1,1};
        System.out.println(findMaxEvenSum(val));
    }

    @Test
    public void test2(){
        int[] val ={-1,1,4,10};
        System.out.println(findMaxEvenSum(val));
    }

    @Test
    public void test3(){
        int[] val ={-1,-1,7,4,10};
        System.out.println(findMaxEvenSum(val));
    }

    @Test
    public void test4(){
        int[] val ={-1, -2, -3,1,4,10};
        System.out.println(findMaxEvenSum(val));
    }
    @Test
    public void test5(){
        int[] val ={-1,1,-3,4,10};
        System.out.println(findMaxEvenSum(val));
    }


    /**
     *
     * @param val=int[]
     * Pseudocode
     * 1. Iterate over the array
     * 2. Find the even sum by adding all even nos, only add nos if sum is greater than prev sum
     * 3. Similarly, find the odd sum by adding all even nos, only add nos if sum is greater than prev sum
     * 4. Keep track of the smallest odd no and smallest positive odd no.
     * 5. If sum of all odd nos is even then return oddsum+evenSum
     * 6. Else find which odd nos is to be subtracted, either smallest odd or positive odd
     * @return long
     */
    private long findMaxEvenSum(int[] val) {
        int evenSum = 0,oddSum=0,posOddVal=Integer.MAX_VALUE, minOddValue=Integer.MAX_VALUE;
        for (int i = 0; i < val.length; i++) {
            if (val[i] % 2 == 0) evenSum = Math.max(evenSum+val[i],evenSum);
            else {
                oddSum = Math.max(oddSum+val[i],oddSum);
                minOddValue=Math.min(minOddValue,val[i]);
                posOddVal=val[i]>0 && val[i]<posOddVal?val[i]:posOddVal;
            }
        }
        if(oddSum%2==1){
            if(minOddValue>0)oddSum-=minOddValue;
            else  oddSum=Math.max(oddSum+minOddValue,oddSum-posOddVal);
        }
        return Math.max(evenSum+oddSum,evenSum);
    }
}
