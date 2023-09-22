package Sorting;


import org.junit.Test;

import java.util.Arrays;

public class MaxProductThreeTest {

    @Test
    public void test1(){
        int[] nums={3,4,1,2,6};
        System.out.println(maxProduct(nums));
        System.out.println(maxProductOpt(nums));
    }


    @Test
    public void test2(){
        int[] nums={3,-4,-1,6};
        System.out.println(maxProduct(nums));
        System.out.println(maxProductOpt(nums));
    }

    @Test
    public void test3(){
        int[] nums={-3,-4,-1,-6};
        System.out.println(maxProduct(nums));
        System.out.println(maxProductOpt(nums));
    }

    /*
        Pseudocode
        1. Sort the array
        2. Max Product is either
            Product of last 3 nos (Max 3 nos)
                    OR
            Product of first 2 and last no (two negative and positive)
     */

    private int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1] );
    }

    /*
        Pseudocode
        1. Iterate the array
        2. Find the 3 max nos and find the 2 smallest elements
        3. Max Product is either
            Product of last 3 nos (Max 3 nos)
                    OR
            Product of first 2 and last no (two negative and positive)
     */
    private int maxProductOpt(int[] nums) {
        int max1=nums[0], max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
        int min1=nums[0], min2=Integer.MAX_VALUE;
        for (int i=1;i<nums.length;i++) {
            if(nums[i]>max1){
                max3=max2;
                max2=max1;
                max1=nums[i];
            }
            else if(nums[i]>max2){
                max3=max2;
                max2=nums[i];
            }
            else if(nums[i]>max3) max3=nums[i];


            if(nums[i]<min1){
                min2=min1;
                min1=nums[i];
            }
            else if(nums[i]<min2)min2=nums[i];
        }
        return Math.max(max1*max2*max3,max1*min1*min2);
    }


}
