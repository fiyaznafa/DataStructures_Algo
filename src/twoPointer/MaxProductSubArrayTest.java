package twoPointer;

import org.junit.Test;
import org.testng.Assert;

public class MaxProductSubArrayTest {

    @Test
    public void test1(){
        int[] nums ={2,3,-4,5,1};
        System.out.println(maxProductSubArrayOpt(nums));
    }

    @Test
    public void test2(){
        int[] nums ={2,3,-4,5,1,-3};
        System.out.println(maxProductSubArrayOpt(nums));
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

    /*
        Optimizing by calculating min and max product
     */

    private int maxProductSubArrayOpt(int[] nums){
        int i=0,curMax=1, curMin=1,temp,res=Integer.MIN_VALUE;
        while(i< nums.length){
            temp=curMax*nums[i];
            curMax=Math.max(nums[i], Math.max(nums[i]*curMax,nums[i]*curMin));
            curMin=Math.min(nums[i],Math.min(temp,nums[i]*curMin));
            i++;
            res=Math.max(res,curMax);
        }
    return res;
    }

}
