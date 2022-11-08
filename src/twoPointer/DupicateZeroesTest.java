package twoPointer;

import org.junit.Test;

import java.util.Arrays;

public class DupicateZeroesTest {

    @Test
    public void test1(){
        int[] nums={1,0,2,3,0,4,5,0};
        duplicateZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2(){
        int[] nums={1,2,3};
        duplicateZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void  test3(){
        int[] nums={8,5,0,9,0,3,4,7};
        duplicateZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
        Pseudocode - Two pointer
        1. Count no of zeroes in the array - count
        2. With one pointer at end j, and other pointer at array length - count add elements to the array
        3. If the element at pointer at lenght-count is zero add two zeroes
     */

    public void duplicateZeros(int[] nums) {
        int countZero = 0;
        for (int num : nums) if (num == 0) countZero++;

        int len = nums.length + countZero;
        for (int j = nums.length - 1, i = len - 1; j < i; j--, i--) {
            if (nums[j] != 0) {
                if (i < nums.length) nums[i] = nums[j];
            } else {
                if (i < nums.length) nums[i] = nums[j];
                i--;
                if (i < nums.length) nums[i] = nums[j]; //copy twice when hit '0'
            }
        }
    }


}
