package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicateTest {

    //80. Remove Duplicates from Sorted Array II
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

    @Test
    public void test1(){
        int[] nums={1,1,1,2,2,3};
        Assert.assertEquals(5,removeDuplicates(nums));
    }

    @Test
    public void test2(){
        int[] nums={0,0,1,1,1,1,2,3,3};
        Assert.assertEquals(7,removeDuplicates(nums));
    }


/*
	Pseudocode - Two pointer
	1. Iterate through the array, Pointer starting from 0th index, till right reaches end of the array
	2. When char at left is equal to character at right increase the count and increment the right pointer
	3. When char at left is not equal to character at right reset the count to 1 and move the left pointer to right
	4. Return left+1
*/

    private int removeDuplicates(int[] nums){
        int count=1,left=0,right=0,index=0;
        while(right<nums.length){
            if(nums[left]==nums[right] && count<=2){nums[index++]=nums[left];count++;}
            else if(nums[left]!=nums[right]){nums[index++]=nums[right];left=right;count=2;}
            right++;
        }
        return index;
    }


   /* private int removeDup(int[] nums){
        if(nums.length==1)return 1;
        int count=0,left=0,right=0;
        while(right<nums.length-1){
            if(nums[right]!=nums[right+1]){
                nums[left++]=nums[right];
                count=1;
            }
            else{
                while( nums[right]==nums[right+1] && right<nums.length-1){
                    if(count<2)nums[left++]=nums[right];
                    count++;
                    right++;
                }
            }
        }
        return left;
    }
*/
}
