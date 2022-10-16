package arrays;

import org.junit.Test;

import java.util.Arrays;

public class ReverseArrayTest {


    @Test
    public void test1(){
        int [] nums = {1,2,3,4,5};
        reverseArr(nums);
    }

    private void reverseArr(int[] nums) {
        int i=0,j= nums.length-1,temp;
        while(i<j){
            temp=nums[i];
            nums[i++]=nums[j];
            nums[j--]=temp;
        }

        System.out.println(Arrays.toString(nums));
    }


}
