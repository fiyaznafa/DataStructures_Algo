package arrays;

import org.junit.Test;

public class MaxSumSubArrayTest {

    @Test
    public void test1(){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSumSubArrayOpt(arr));
    }

    @Test
    public void test2(){
        int[] arr = {5,4,-1,7,8};
        System.out.println(maxSumSubArrayOpt(arr));
    }

    @Test
    public void test3(){
        int[] arr = {-5,-4,-1,-7,-8};
        System.out.println(maxSumSubArrayOpt(arr));
    }

    @Test
    public void test4(){
        int[] arr = {-5,-4,-1,-7,17};
        System.out.println(maxSumSubArrayOpt(arr));
    }

    @Test
    public void test5(){
        int[] arr = {5,4,-9};
        System.out.println(maxSumSubArrayOpt(arr));
    }



    /*
        Pseudocode
        1. Iterate the array
        2. Calculate sum by adding each element and maxSum tracks the maxSum
        4. If sum becomes <0 set sum as 0
        3. Keep track of the largest element
        4. If maxSum is zero return the largest element
        5. Else return maxSum
     */

    private int maxSumSubArray(int[] arr) {
        int maxSum=0,sum=0,maxNo=arr[0];
        for (int i:arr) {
            maxNo=Math.max(maxNo,i);
            sum+=i;
            if(sum<0)sum=0;
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum==0?maxNo:maxSum;
    }

    /*
        Pseudocode
        1. Assign maxSum and Sum to be the first elements
        2. Iterate through the array and calculate sum
        3. If prev sum is less than zero then current sum will be the curr element in iteration
        4. Return the max sum
     */

    private int maxSumSubArrayOpt(int[] nums) {
        int maxSum=nums[0],sum=nums[0];
        for (int i=1;i<nums.length;i++) {
            sum=nums[i]  + (sum>0?sum:0);
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }





}
