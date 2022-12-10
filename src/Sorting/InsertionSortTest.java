package Sorting;

import org.junit.Test;

import java.util.Arrays;

public class InsertionSortTest {

    @Test
    public void test1(){
        int[] nums = {6,2,0,1,3};
        sortArray(nums);
    }



    @Test
    public void test2(){
        int[] nums = {6,2,0,1,3};
      //sortArrayDesc(nums);
    }


    private void sortArray(int[] nums) {
        int pivot,j;
        for (int i = 0; i < nums.length ; i++) {
            pivot=nums[i];
            j=i-1;
            while (j>=0 && nums[j]>pivot){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=pivot;

        }
        System.out.println(Arrays.toString(nums));
    }


}
