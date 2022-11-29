package twoPointer;

import org.junit.Test;

import java.util.Arrays;

public class MoveZeroesEndTest {
    @Test
    public void test1(){
        int[] nums={1,2,0,3,0,4};
        int[] output = moveZeroesEnd(nums);
        System.out.println(Arrays.toString(output));
    }

    @Test
    public void test2(){
        int[] nums={1,2,0,0,0,4,5};
        int[] output = moveZeroesEnd(nums);
        System.out.println(Arrays.toString(output));
    }

    @Test
    public void test3(){
        int[] nums={0};
        int[] output = moveZeroesEnd(nums);
        System.out.println(Arrays.toString(output));
    }
    /*
        Pseudocode - Two pointer
        1. With two pointer 1st starting at 0th index and 2nd starting at 2nd index iterate the array
        2. If no at left is zero swap with right
     */

    private int[] moveZeroesEnd(int[] nums) {
        if(nums.length==1)return nums;
        int left=0,right=1,temp=0;
        while(right< nums.length){
            if(nums[left]==0){
                temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                if(nums[left]!=0)left++;
            }
            else left++;
            right++;
        }
        return nums;
    }

}
