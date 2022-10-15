package arrays;


import org.junit.Test;

import java.util.Arrays;

public class TwoSumBruteForce {

    @Test
    public void test1(){
        int[] nums ={2,7,11,15};
        int target =9;
        System.out.println(Arrays.toString(findTwoSum(nums,target)));    }

    @Test
    public void test2(){
        int[] nums ={};
        int target=6;
        System.out.println(Arrays.toString(findTwoSum(nums,target)));
    }

    @Test
    public void test3(){
        int[] nums ={2,3,4,5,6,7,8};
        int target=9;
        System.out.println(Arrays.toString(findTwoSum(nums,target)));
    }

    /* 0) validation: check array size.. if it is less than 2, return empty array
     * 1) traverse through array from 0 to n-1 index
     * 2) add the indice values and
     * 3) compare against the target
     * 4) If it matches, store the start - end index
     * 5) Else, continue
            * 6) Finally, return the last matching index !!
            * 7) If there are no matches --> then return empty array !!
        */

    private int[] findTwoSum(int[] nums, int target) {
        if(nums.length<2) {return  new int[]{}; }

        int[] output = new int[2];

        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i; j < nums.length ; j++) {
                if(nums[i]+nums[j]==target){
                    output[0]=i;
                    output[1]=j;
                }
            }

        }
        return output;
    }
}
