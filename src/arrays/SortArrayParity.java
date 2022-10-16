package arrays;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SortArrayParity {

    //https://leetcode.com/problems/sort-array-by-parity/

    @Test
    public void test1(){
        int [] nums={3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByPariyt(nums)));
    }

    @Test
    public void test2(){
        int [] nums={3,1,5,7};
        System.out.println(Arrays.toString(sortArrayByPariyt(nums)));
    }

    @Test
    public void test3(){
        int [] nums={};
        System.out.println(Arrays.toString(sortArrayByPariyt(nums)));
    }

    @Test
    public void test4(){
        int [] nums={0,1,2};
        System.out.println(Arrays.toString(sortArrayByPariyt(nums)));
    }

    @Test
    public void test5(){
        int [] nums={0,2};
        System.out.println(Arrays.toString(sortArrayByPariyt(nums)));
    }

    /*
        1. Iterate through the loop from the end till it meets the even no
        2. If character is even move it to the first and increment the start count
        3. Keep iterating till left crosses right
     */

    private int[] sortArrayByPariyt(int[] nums) {
        int i=0,temp;
        for(int j= nums.length-1;j>i;j--){
            while (nums[i]%2==0 && i< nums.length-1)i++;
            if(nums[j]%2==0 && j>i) {
                temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                i++;
            }
        }
        return nums;
    }


}
