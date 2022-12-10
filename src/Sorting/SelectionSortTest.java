package Sorting;

import org.junit.Test;

import java.util.Arrays;

public class SelectionSortTest {

    @Test
    public void test1(){
        int[] nums = {7,2,4,8,1,22,17,18};
        sortArray(nums);
    }

    @Test
    public void test2(){
        int[] nums = {7,2,4,8,1,22,17,18};
        sortArrayDesc(nums);
    }

    /*
        1. Iterate the array
        2. For index of the smallest element
        3. Check if it is smallest if it is smaller than the curr element then swap
     */

    private void sortArray(int[] nums) {
        int min,temp = 0;
        for (int i = 0; i < nums.length-1;i++ ) {
            min=i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[min]>nums[j]) min=j;
            }
            if(min!=i){
                temp=nums[i];
                nums[i]=nums[min];
                nums[min]=temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void sortArrayDesc(int[] nums) {
        int max,temp;
        for (int i = 0; i < nums.length-1;i++ ) {
            max=i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[max]<nums[j]) max=j;
            }if(max!=i){
            temp=nums[i];
            nums[i]=nums[max];
            nums[max]=temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
