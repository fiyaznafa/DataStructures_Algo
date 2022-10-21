package arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticTripletsTest {

    //https://leetcode.com/problems/number-of-arithmetic-triplets/


/*
	nums = [0,1,4,6,7,10]
	diff = 3


	nums = [4,5,6,7,8,9],
	diff = 2
*/

    @Test
    public void test1(){
        int[] nums={4,5,6,7,8,9,10};
        int diff=2;
        System.out.println(noOfArithmeticTriplet(nums,diff));
    }

    @Test
    public void test2(){
        int[] nums={2,3,4,5,6,7};
        int diff=4;
        System.out.println(noOfArithmeticTriplet(nums,diff));
    }

    @Test
    public void test3(){
        int[] nums={0,1,4,6,7,10};
        int diff=3;
        System.out.println(arithmeticTriplet(nums,diff));
    }

    @Test
    public void test4(){
        int[] nums={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,92,93,94,95,96,97,98,99,100};
        int diff=10;
        System.out.println(arithmeticTriplet(nums,diff));
    }


/*
	Pseudocode
	1. Iterate through the array
	2. With two pointer left at 0th index and right at 1st index iterate through the loop
	3. if left-right >diff , move left and right=left+1
	4. if left - right<diff, move right
	5. if left-right = diff, move right
		check if left -right == (2* diff) ,
*/

    private int noOfArithmeticTriplet(int[] nums,int diff){
        int left=0,right=1,count=0;
        int match=diff;
        boolean flag=false;
        while(left<nums.length-2 ){
            if( right==nums.length || nums[right]-nums[left] >match ){
                left++;
                right=left+1;
                flag=false;
                match=diff;
            }
           else if(nums[right]-nums[left]==match){
                if(flag){
                    match=diff;
                    left++;
                    right=left+1;
                    count++;
                    flag=false;
                }
                else{
                    right++;
                    match = diff*2;
                    flag=true;
                }
            }

            else right++;
        }
        return count;
    }

    /*
        Pseudocode
        1. Add all elements to list
        2. Iterate through the list
        3. Check if list contains nums + diff && nums + (2*diff), increment count
     */

    private int arithmeticTriplet(int[] nums,int diff){
        List<Integer> list = new ArrayList<>();
        int count =0;
        for(int eachNum: nums){
            if(list.contains(eachNum-diff)&& list.contains(eachNum-(2*diff)))count++;
            list.add(eachNum);
        }
        return count;
    }


}
