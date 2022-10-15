package arrays;

import org.testng.annotations.Test;

import java.util.Arrays;

public class RemoveElemetnSortedArray {
    //https://leetcode.com/problems/remove-element/

    @Test
    public void test1(){
        int[] nums = {3,2,2,3};
        int k=3;
        System.out.println(removeElement(nums, k));
    }

    @Test
    public void test2(){
        int[] nums = {3,2,2,3};
        int k=1;
        System.out.println(removeElement(nums, k));    }

    @Test
    public void test3(){
        int[] nums = {1,1,1,1};
        int k=1;
        System.out.println(removeElement(nums, k));    }

    /*
        Pseudo Code - Two Pointer
        1. Iterate through the num array.
        2. If element at i==target, swap with the next element
        3. Stopping condition when 2nd pointer reaches end
        4. Return k, with position of i
     */

    private int removeElement(int[] nums, int target) {
        int i=0,j=0,temp=0;
        boolean flag=false;
        for (; j < nums.length;j++ ) {
            if(nums[i]!=target)i++;
            else {
                while(j<nums.length-1 && nums[j]==target)j++;
                if(nums[j]!=target) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i++] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }
}
