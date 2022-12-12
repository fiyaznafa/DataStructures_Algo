package Sorting;

import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {
    @Test
    public void test1(){
        int[] nums = {7,2,4,8,1,22,17,18};
        sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
    }

    private void sort(int[] nums, int start, int end) {
        if(start<end){
          int mid = (start+end)/2;
          sort(nums,start,mid);
          sort(nums,mid+1,end);
          merge(nums,start,mid,end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end-start+1];
        int left=start,right=mid+1,index=0;
        while(left<=mid && right<=end) {
            if (nums[left] < nums[right])
                temp[index++] = nums[left++];
            else temp[index++] = nums[right++];
        }
            while(left<=mid)temp[index++]=nums[left++];
            while(right<=end)temp[index++]=nums[right++];

            for(int i=start;i<=end;i++)nums[i]=temp[i-start];

    }

}
