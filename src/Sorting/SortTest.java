package Sorting;

import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    @Test
    public void test1(){
        int[] nums = {6,2,0,1,3};
        sortArray(nums);
    }

    private void sortArray(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
