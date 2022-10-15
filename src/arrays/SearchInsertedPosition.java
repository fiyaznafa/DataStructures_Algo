package arrays;

import org.testng.annotations.Test;

public class SearchInsertedPosition {
    //https://leetcode.com/problems/search-insert-position/

    @Test
    public void test1(){
        int[] nums ={1,3,5,6};
        int target=5;
        System.out.println(searchPosition(nums,target));
    }

    @Test
    public void test2(){
        int[] nums ={1,3,5,6};
        int target =2;
        System.out.println(searchPosition(nums,target));
    }

    @Test
    public void test3(){
        int[] nums ={1,3,5,6};
        int target =7;
        System.out.println(searchPosition(nums,target));
    }

    @Test
    public void test4(){
        int[] nums ={1,3,5,6};
        int target =0;
        System.out.println(searchPosition(nums,target));
    }


    @Test
    public void test5(){
        int[] nums ={1,3,5,6,8,9};
        int target =7;
        System.out.println(searchPosition(nums,target));
    }


    private int searchInsertedPosition(int[] nums, int target) {

        int start=0,end=nums.length-1;
        int mid = (start+end)/2;


        if(target>nums[end])return nums.length;
        else if(target<nums[start])return 0;
        else{

            while(nums[mid]!=target) {
                if (nums[mid] > target) end = mid;
                else start = mid;
                mid = (start + end) / 2;

                if (nums[mid] > target && target>nums[start] && mid - start == 1) return mid;
                else if (nums[end] > target && target > nums[mid] && end - mid == 1) return end;

            }
        }

        return mid;
    }


    private int searchPosition(int[] nums, int target){

        int left=0,right = nums.length-1,mid=0;
        while(left<=right) {
            mid=(left+right)/2;
            if(nums[mid]==target)return mid;
            else if(target>nums[mid])left=mid+1;
            else right=mid-1;
        }
        return left;
    }

}
