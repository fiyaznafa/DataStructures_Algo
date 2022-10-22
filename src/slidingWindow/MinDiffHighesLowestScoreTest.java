package slidingWindow;

import org.junit.Test;

import java.util.Arrays;

public class MinDiffHighesLowestScoreTest {
    //https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/


/*
	Test Data
	1. num ={1,4,7,9,13},k=3
	2. num ={1,6,8,10,13,9},k=4
*/


/*
	Pseudocode
	1. Sort the array
	2. Assign min is 0
	3. Iterate till i is k
	4. Difference of i and i-k element
	6. If difference is less then prev diff , current difference is minmum
*/

    @Test
    public void test1(){
        int[] nums= {1,4,7,9,13};
        int k=3;
        System.out.println(minDifference(nums,k));
    }

    @Test
    public void test2(){
        int[] nums= {1,6,8,10,13,9};
        int k=4;
        System.out.println(minDifference(nums,k));
    }

    @Test
    public void test3(){
        int[] nums= {90};
        int k=1;
        System.out.println(minDifference(nums,k));
    }

    private int minDifference(int[] nums, int k){
        Arrays.sort(nums);
        int min,diff;
        int i=0;
        while(i<k)i++;
        min=nums[i-1]-nums[i-k];

        while(i<nums.length){
            diff=nums[i]-nums[i-k+1];
            min=Math.min(min,diff);
            i++;
        }
        return min;
    }
}
