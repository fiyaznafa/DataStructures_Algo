package Misc.ThreePointers;

import org.junit.Test;

import java.util.Arrays;

public class SortArrayNonDecreasingTest {
    @Test
    public void test1(){
        int[] nums = {1,2,1,0,2,0};
        System.out.println(Arrays.toString(sortArray(nums)));
    }


    @Test
    public void test2(){
        int[] nums = {2,2,1,1,2,0};
        System.out.println(Arrays.toString(sortArray(nums)));
    }

    private int[] sortArray(int[] nums) {
        int left=0, right= nums.length-1;
        int[] output = new int[nums.length];
        int i=0;
        while(i<nums.length){
            if(nums[i]==0)output[left++]=0;
            else if(nums[i]==2)output[right--]=2;
            i++;
        }
        while(left<=right)output[left++]=1;
        return output;
    }
}
