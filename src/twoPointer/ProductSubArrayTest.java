package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class ProductSubArrayTest {
    //https://leetcode.com/problems/subarray-product-less-than-k/

    @Test
    public void test1(){
        int[] nums = {10,5,2,6,100};
        int k = 100;
        Assert.assertEquals(8,subArrayProductOptimized(nums,k));
    }


    @Test
    public void test2(){
        int[] nums = {1,2,3,4};
        int k = 0;
        Assert.assertEquals(0,subArrayProductOptimized(nums,k));
    }

    @Test
    public void test3(){
        int[] nums = {1};
        int k = 2;
        Assert.assertEquals(1,subArrayProductOptimized(nums,k));
    }

    @Test
    public void test4(){
        int[] nums = {57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
        int k = 18;
        Assert.assertEquals(1,subArrayProductOptimized(nums,k));
    }

    @Test
    public void test5(){
        int[] nums = {100,10,5,2,6,100};
        int k = 100;
        Assert.assertEquals(8,subArrayProductOptimized(nums,k));
    }

/*
	Pseudocode - Brute force
	1. Using two loop , find the product of ith element with i+1th element
	2. Keep incrementing count until product is less than target

	Approach 2 - Two pointer
	1. Left Pointer at 0th index iterate the loop
	2. Find the product by multiplying with right element
	3. If lesser than try and divide until it is less
*/

    private int subArrayProduct(int[] nums, int target){
        int count=0, product=1;
        if(nums.length<2) return nums[0]<target?1:0;
        for(int i=0;i<nums.length;i++){
            product*=nums[i];
            if(product<target)count++;
            else {
                product=1;
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                product*=nums[j];
                if(product<target)count++;
                else break;
            }
            product=1;
        }
        return count;
    }

    private int subArrayProductOptimized(int[] nums,int target){
        int left=0,right=0,count=0,product=1;
        while (right<nums.length){
            product*=nums[right];
            while(product>=target && left<=right)product/=nums[left++];
            count+=right-left+1;
            right++;
        }
        return count;
    }
}
