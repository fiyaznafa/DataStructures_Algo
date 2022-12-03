package twoPointer;

import org.junit.Test;

public class MaxConsecutiveOnesIIITest {
    //https://leetcode.com/problems/max-consecutive-ones-iii/
//Max Consecutive Ones III

    @Test
    public void test1(){
        int[] num={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        System.out.println(longestOnes(num,k));
    }

    @Test
    public void test2(){
        int[] num={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(num,k));
    }

/*
	Pseudocode - Two pointer
	1. With both pointer left and right iterate the array
	2. If char at right is 1 , increase the lengthCount
	3. If char at right is 0 and k is greater than 0 increase the lengthCount  k--
	4. If char at right is 0 and k is 0 , move the left pointer till char is 0
*/

    public int longestOnes(int[] nums, int k) {
        int left =0,right =0, maxLength=0;
        while(right<nums.length){
            if(nums[right]==0 && k>0)k--;
            else if(nums[right]==0 && k==0){
                while(nums[left]!=0){left++;}
                left+=1;
            }
            maxLength=Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }

}
