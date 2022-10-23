package slidingWindow;

import org.junit.Test;


public class MinSizeSubArrayTest {

    //https://leetcode.com/problems/minimum-size-subarray-sum/


    @Test
    public void test1(){
        int[] nums = {2,3,1,2,4,3};
        int target=7;
        System.out.println(minSubarraySum(nums,target));
    }

    @Test
    public void test2(){
        int[] nums = {1,4,4};
        int target=4;
        System.out.println(minSubarraySum(nums,target));
    }


    @Test
    public void test3(){
        int[] nums = {1,1,1,1,1,1,1,1};
        int target=11;
        System.out.println(minSubarraySum(nums,target));
    }

    @Test
    public void test4(){
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int target=213;
        System.out.println(minSubarraySum(nums,target));
    }

/*
	Pseudocode
	1. Two pointer left at 1 , right at 1. Iterate. Assign sum =left;
	2. Check if sum < target ,add right
	3. Check if sum > target , remove left
	4. If matches store min as right -left
*/

    private int minSubarraySum(int[] nums, int target){
        int left=0,right=0,sum=0,min=Integer.MAX_VALUE;

        while(right<nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        if(min==Integer.MAX_VALUE)return 0;
        return min;
    }

}
