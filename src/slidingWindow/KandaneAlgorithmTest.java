package slidingWindow;

import org.junit.Test;
import org.testng.Assert;

public class KandaneAlgorithmTest {

    /* This Algo is to solve max sum of sub array.
        Constraint:  There must be at least one non-negative no.
        Pseudocode
        1. Iterate the array,and keep calculating the sum
        2. If sum is negative , reset the sum to zero
        3. Return the max of sum
    */

    @Test
    public void test1(){
        int[] nums={-2,4,-4,3,2,1,-1,-4};
        Assert.assertEquals(6,maxSumSubArray(nums));
    }

    @Test
    public void test2(){
        int[] nums={1,4,-4,0,-1,3,2,1,-1,2};
        Assert.assertEquals(7,maxSumSubArray(nums));
    }


    @Test
    public void test3(){
        int[] nums={-4,-2,-3,0,-1,-3};
        Assert.assertEquals(0,maxSumSubArray(nums));
    }

    private int maxSumSubArray(int[] nums) {
        int i=0,sum=0,maxSum=Integer.MIN_VALUE;
        while (i<nums.length){
            sum+=nums[i++];
            if(sum<0)sum=0;
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }


}
