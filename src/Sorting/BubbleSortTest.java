package Sorting;

import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {

    @Test
    public void test1(){
        int[] nums = {6,2,0,1,3};
        sortArray(nums);
    }

    @Test
    public void test2(){
        int[] nums = {6,2,0,1,3};
        sortArrayDesc(nums);
    }

    /*
        1. Iterate the array
        2. In the inner loop find the max and keep swapping till the end (Bubble out max value to end)

     */


    private void sortArray(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-1-i ; j++) {
                if(nums[j]>nums[j+1]){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }



    private void sortArrayDesc(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-1-i ; j++) {
                if(nums[j]<nums[j+1]){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
