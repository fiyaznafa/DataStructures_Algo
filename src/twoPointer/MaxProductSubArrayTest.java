package twoPointer;

import org.junit.Test;
import org.testng.Assert;

public class MaxProductSubArrayTest {

    @Test
    public void test1(){
        int[] nums ={2,3,-4,5,1};
        Assert.assertEquals(6,maxProductSubarray(nums));
    }

    @Test
    public void test2(){
        int[] nums ={2,3,-4,5,1,-3};
        Assert.assertEquals(360,maxProductSubarray(nums));
    }

    @Test
    public void test3(){
        int[] nums ={2,3,0,5,1,3,-2};
        Assert.assertEquals(15,maxProductSubarray(nums));
    }

    private int maxProductSubarray(int[] nums) {
        int product=1,maxProduct=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i; j < nums.length ; j++) {
                product*=nums[j];
                maxProduct=Math.max(product,maxProduct);

            }
            product=1;
        }
        return maxProduct;
    }
}
