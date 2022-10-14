package arrays;

import org.testng.annotations.Test;

import java.util.Arrays;

public class RemoveDuplicateSortedArray {
    //Question - https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    @Test
    public void test1(){
        int nums[] ={0,0,0,1,1,1,2,2,3,3,4};
        int[] ints = removeDuplicates(nums);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test2(){
        int nums[] ={1,1,2};
        int[] ints = removeDuplicates(nums);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test3(){
        int nums[] ={1,2};
        int[] ints = removeDuplicates(nums);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test4(){
        int nums[] ={1,1};
        int[] ints = removeDuplicates(nums);
        System.out.println(Arrays.toString(ints));
    }


    private int[] removeDuplicates(int[] nums) {
        if(nums.length==2 && nums[0]!=nums[1]) {System.out.println(2); return nums;}
        else if(nums.length==2 && nums[0]==nums[1]){System.out.println(1); return nums;}

        else{
            int i=0,j=1;
            for(; j< nums.length;){
                while(nums[i]==nums[j] && j< nums.length)j++;
                if(nums[i]!=nums[j]) nums[++i]=nums[j++];
            }
            System.out.println(i+1);
            return nums;
        }
    }

}
