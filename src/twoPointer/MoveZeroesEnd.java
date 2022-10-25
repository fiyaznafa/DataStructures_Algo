package twoPointer;


import org.junit.Test;

import java.util.Arrays;

public class MoveZeroesEnd {

    @Test
    public void test1(){
        int[] arr = {1,0,0,1,1,0};
        int[] output= moveZeroToEnd(arr);
        System.out.println(Arrays.toString(output));
    }

    @Test
    public void test2(){
        int[] arr ={1,1,1,1,1};
        int[] output= moveZeroToEnd(arr);
        System.out.println(Arrays.toString(output));
    }

    @Test
    public void test3(){
        int[] arr ={0,0,0,0,0};
        int[] output= moveZeroToEnd(arr);
        System.out.println(Arrays.toString(output));
    }

    @Test
    public void test4(){
        int[] arr ={0,1,0,3,12};
        System.out.println(Arrays.toString(moveZeroesInplace(arr)));
    }

    private int[] moveZeroToEnd(int[] arr) {
        int size=arr.length;

        if(size==0)
            return new int[] {};

        int[] output= new int[size];
        int x=0, y=size-1;

        for (int i=0;i<size;i++) {
            if(arr[i]==0)  output[y--]=0;
            else output[x++]=1;
        }
        return output;
    }


    /*
        Pseudocode
        1. Move left & right if both are non zero
        2. If left is zero and right is non zero swap
        3. If left is zero right is also zero move left alone

     */
    private int[] moveZeroesInplace(int[] nums){
        int left=0, right=1,temp=0;

        while(right<nums.length){
            if(nums[left]==0 && nums[right]!=0) {
                temp=nums[left];
                nums[left++]=nums[right];
                nums[right++]=temp;
            }else if(nums[left]==0 && nums[right]==0) right++;
            else {
                left++;
                right++;
            }
        }
        return nums;
    }

}
