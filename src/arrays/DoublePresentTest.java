package arrays;

import org.junit.Test;

import java.util.Arrays;

public class DoublePresentTest {
    //https://leetcode.com/problems/check-if-n-and-its-double-exist/

/*
	Test Data
	1. Positive  	nums - 10,2,5,3
	2. Negative 	nums - 7,9,10,11,12
	3. Edge			nums - 18,9,2,3,7,8


	Pseudocode
	1. Sort the array
	2. Take two pointer left - start of array and right end of array
	3. Iterate throgh the array untill left<right
	4. If value at right < double of left return false
	5. If value at right is less than double move left
	6. If value at right is equal to dubale of left return true
*/


    @Test
    public void test1(){
        int[] nums ={10,2,5,3};
        System.out.println(isDoublePresent(nums));
    }

    @Test
    public void test2(){
        int[] nums ={7,9,10,11,12};
        System.out.println(isDoublePresent(nums));
    }

    @Test
    public void test3(){
        int[] nums ={-10,12,-20,-8,15};
        System.out.println(isDoublePresent(nums));
    }

    @Test
    public void test4(){
        int[] nums ={0,12,-20,-8,15,0};
        System.out.println(isDoublePresent(nums));
    }

    private boolean isDoublePresent(int[] nums){
        if(nums.length<2) return false;
        Arrays.sort(nums);
        int left=0,right =1;
        while(right<nums.length ){
            if(left==right && right< nums.length-1)right++;
            if(nums[left]<0){
                if(nums[left]<(2*nums[right]))left++;
                else if(nums[left]>(2*nums[right]))right++;
                else return true;
            }
            else if (nums[left]==0 && nums[right]==0)return true;
            else{
                if(nums[right]<(2*nums[left]))right++;
                else if(nums[right]>(2*nums[left]))left++;
                else return true;
            }
        }
        return false;
    }
}
