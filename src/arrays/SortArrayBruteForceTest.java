package arrays;

import org.junit.Test;

import java.util.Arrays;

public class SortArrayBruteForceTest {

    @Test
    public void test1() {
        int[] nums = {90, 23, 5, 109, 12, 22, 67, 34};
        System.out.println(Arrays.toString(sortArray(nums)));
    }


    @Test
    public void test2() {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(sortArray(nums)));
    }

    /*Pseudocode
    * 1. Iterate through loop for each element
    * 2. Check if first element is less than second , if less than swap
    * 3. Continue the process comparing first until last element
    * 4. Repeat Step 2 & 3 for all elements in the loop
    */
    private int[] sortArray(int[] nums){

        int temp;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i; j<nums.length;j++){
                if(nums[i]>nums[j]){
                    temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]= temp;
                }
            }
        }
        return nums;
    }

}
