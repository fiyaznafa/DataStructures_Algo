package slidingWindow;

import org.junit.Test;

public class AverageConsecutiveNosTest {

    // https://leetcode.com/problems/maximum-average-subarray-i/


/*
	Test Data 
	1. nums = [1,12,-5,-6,50,3], k = 4
	2. nums = [5], k = 1
	3. nums  [16,1,6,3] , k= 5
*/


/*
	PseudoCode
	1. Iterate the array and find the average till k and assign maxAverage
	2. Iterate the array from k till end
	3. Add the next element and remove the left value , check if average > maxAverage
*/

    @Test
    public void test1(){
        int[] nums ={1,12,-5,-6,50,3};
        int k=4;
        System.out.println(maxAverage(nums,k));
    }

    @Test
    public void test2(){
        int[] nums ={5};
        int k=1;
        System.out.println(maxAverage(nums,k));
    }


    private double maxAverage(int[] nums,int k){
        int i=0;
        int sum = 0;
        double maxAverage;
        while(i<k)
            sum+=nums[i++];
        maxAverage=(double) sum/k;

        while(i<nums.length){
            sum=sum-nums[i-k]+nums[i++];
            maxAverage=Math.max(maxAverage,(double) sum/k);
        }
        return maxAverage;
    }
}
