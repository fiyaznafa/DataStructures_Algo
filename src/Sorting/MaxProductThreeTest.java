package Sorting;

import org.testng.annotations.Test;

import java.util.Arrays;

public class MaxProductThreeTest {

    @Test
    public void test1(){
        int[] nums={3,4,1,2,6};
        System.out.println(maxProduct(nums));
    }


    @Test
    public void test2(){
        int[] nums={3,-4,-1,6};
        System.out.println(maxProduct(nums));
    }

    @Test
    public void test3(){
        int[] nums={-3,-4,-1,-6};
        System.out.println(maxProduct(nums));
    }

    private int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1] );
    }

}
