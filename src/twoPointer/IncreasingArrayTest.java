package twoPointer;

import org.junit.Test;

public class IncreasingArrayTest {
    //x

    @Test
    public void test1(){
        int[] nums = {1,2,10,5,7,11};
        System.out.println(canBeInreasing(nums));
    }

    @Test
    public void test3() {
        int[] nums = {3, 1, 2, 5, 7};
        System.out.println(canBeInreasing(nums));
    }

    @Test
    public void test6(){
        int[] nums = {105,924,32,968};
        System.out.println(canBeInreasing(nums));
    }


    @Test
    public void test8(){
        int[] nums = {2,3,1,2};
        System.out.println(canBeInreasing(nums));
    }

    /*
     *	PseudoCode
     *	1) Using two pointers left and right and a count variable
     *	2) if left < right , move both index
     *	3) Else increase count
     *  	4) if count >1 return false ; else return true
     */


    private boolean canBeInreasing(int[] nums){
        if(nums.length==0) return false;
        int count=0;
        for(int left=0,right=1;right<nums.length;left++,right++){
            if(nums[left]>=nums[right]) {
                count++;
                if(left!=0 && nums[left-1] >=nums[right])nums[right]=nums[left];
            }
            if(count>1)return false;
        }
        return true;
    }













}
