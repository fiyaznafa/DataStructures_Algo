package twoPointer;


import org.junit.Test;

import java.util.Arrays;

public class SortArrayParityTest {

    //https://leetcode.com/problems/sort-array-by-parity/

    @Test
    public void test1(){
        int [] nums={3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    @Test
    public void test2(){
        int [] nums={3,1,5,7};
        System.out.println(Arrays.toString(sortArrayByPairtyEquiDirectional(nums)));
    }

    @Test
    public void test3(){
        int [] nums={};
        System.out.println(Arrays.toString(sortArrayByPairtyEquiDirectional(nums)));
    }

    @Test
    public void test4(){
        int [] nums={0,1,2};
        System.out.println(Arrays.toString(sortArrayByPairtyEquiDirectional(nums)));
    }

    @Test
    public void test5(){
        int [] nums={0,2};
        System.out.println(Arrays.toString(sortArrayByPairtyEquiDirectional(nums)));
    }

    /*
        1. Iterate through the loop from the end till it meets the even no
        2. If character is even move it to the first and increment the start count
        3. Keep iterating till left crosses right
     */

    private int[] sortArrayByParity(int[] nums) {
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

    private int[] sortArrayByPairtyEquiDirectional(int[] nums){
        int left =0,right=0,temp;
        while(right< nums.length){
            if(nums[right]%2==0 && nums[left]%2!=0){
                temp=nums[left];
                nums[left++]=nums[right];
                nums[right]=temp;
            }
            if(right==left &&nums[left]%2==0){
                left++;
            }
            right++;
        }
        return nums;
    }



}
