package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class MaximumConsecOneTest {
    //https://leetcode.com/problems/max-consecutive-ones-iii/

    @Test
    public void test1(){
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        Assert.assertEquals(6,maxConsecutiveOne(nums,k));
    }


    @Test
    public void test2(){
        int[] nums={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        Assert.assertEquals(10,maxConsecutiveOne(nums,k));
    }

/*
	Pseudocode - Two pointer
	1. With left pointer  and right pointer at 0 index
	2. Iterate the array until no of zeroes is equal to target, store the length in temp var
	3. If next element is also zero keep reducing left until no of zeroes count is equal to k
	4. Keep adding to right if value is 1.
*/

    private int maxConsecutiveOne(int[] nums, int k){
        int left=0,right =-1, noZeroes=0,maxLength=Integer.MIN_VALUE;
        while(right<nums.length-1){
            if(nums[right+1]==1)right++;
            else if(noZeroes<k && nums[right+1]==0){
                noZeroes++;
                right++;
            }
            else if(noZeroes>=k && nums[right+1]==0){
                if(nums[left]==0) noZeroes--;
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
