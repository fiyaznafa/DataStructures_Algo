package Misc.ThreePointers;


import org.junit.Test;

import java.util.Arrays;

public class DutchFlagAlgoTest {
    //This Algo is to sort 3 items only

    @Test
    public void test1(){
        int[] nums={1,2,0,1,2,0,1,0,2};
        System.out.println(Arrays.toString(sortThreeNosAscending(nums)));
    }

    @Test
    public void test2(){
        int[] nums={1,2,0,1,2,0,1,0,2};
        System.out.println(Arrays.toString(sortThreeNosDescending(nums)));
    }



    private int[] sortThreeNosAscending(int[] nums) {
        int left=0,mid=0,right=nums.length-1,temp;
        while(mid<=right){
            if(nums[mid]==1)mid++;
            else if(nums[mid]==0){
                temp=nums[mid];
                nums[mid++]=nums[left];
                nums[left++]=temp;
            }
            else {
                temp=nums[mid];
                nums[mid]=nums[right];
                nums[right--]=temp;
            }
        }
        return nums;
    }

    private int[] sortThreeNosDescending(int[] nums) {
        int left=0,mid=0,right=nums.length-1,temp;
        while(mid<=right){
            if(nums[mid]==1)mid++;
            else if(nums[mid]==2){
                temp=nums[mid];
                nums[mid++]=nums[left];
                nums[left++]=temp;
            }
            else {
                temp=nums[mid];
                nums[mid]=nums[right];
                nums[right--]=temp;
            }
        }
        return nums;
    }

}
