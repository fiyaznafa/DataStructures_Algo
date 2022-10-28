package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubarrayOneTest {
//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

//Start 16:36 - 16:40      Overall 16:36 -17:25

    @Test
    public void test1(){
        int[] nums={1,1,0,1};
        Assert.assertEquals(3,longestOne(nums));
    }


    @Test
    public void test2(){
        int[] nums={0,1,1,1,0,1,1,0,1};
        Assert.assertEquals(5,longestOne(nums));
    }


    @Test
    public void test3(){
        int[] nums={1,1,1,1};
        Assert.assertEquals(3,longestOne(nums));
    }

    @Test
    public void test4(){
        int[] nums={0,0,0,0};
        Assert.assertEquals(0,longestOne(nums));
    }

/*	16:41 - 16:45
	Psuedocode - Two pointer
	1. Two pointer left at 0 and right at 0 iterate till right reaches end
	2. If element at right is 1, move right
	3. If element at right is 0 , add a flag for delete item and move right
	4. If element at right is 0 and flag is set keep moving left till flag is set to false
	5. Calcuate the max lenght - right -left if flag is not set, or right-left-1 if flag is set
*/


    // 16:45 - 16:50 Debug 16:52 - 17:25
    private int longestOne(int[] nums){
        int left=0, right =0, length=0;
        boolean flag=false;
        while(right<nums.length){
            if(nums[right]==0 && !flag)flag=true;
            else if(nums[right]==0 &&flag){
                while(nums[left]!=0 && left<right )left++;
                left++;
            }

            length=Math.max(length,right-left+1);
            right++;
        }
        return length-1;
    }

}
