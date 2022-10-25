package twoPointer;

import org.junit.Test;

import java.util.Arrays;

public class MergeSortedArrayTest {
    //https://leetcode.com/problems/merge-sorted-array/

    @Test
    public void test1(){
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int [] nums2 = {2,5,6};
        int n = 3;
        System.out.println(Arrays.toString(mergeSortedArray(nums1,m,nums2,n)));
    }

    @Test
    public void test2(){
        int[] nums1 = {1};
        int m = 1;
        int[] nums2={};
        int n = 0;
        System.out.println(Arrays.toString(mergeSortedArray(nums1,m,nums2,n)));
    }


    @Test
    public void test3(){
        int[] nums1 = {0};
        int m = 0;
        int[] nums2={1};
        int n = 1;
        System.out.println(Arrays.toString(mergeSortedArray(nums1,m,nums2,n)));
    }

    @Test
    public void test4(){
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int [] nums2 = {1,2,3};
        int n = 3;
        System.out.println(Arrays.toString(mergeSortedArray(nums1,m,nums2,n)));
    }

    @Test
    public void test5(){
        int[] nums1 = {2,0};
        int m = 1;
        int [] nums2 = {1};
        int n = 1;
        System.out.println(Arrays.toString(mergeSortedArray(nums1,m,nums2,n)));
    }
/*
	PseudoCode - Two pointer
	1. Check if n-0, return nums1
	2. Check if m-0 , copy array nums2 into nums1
	3. Iterate loop for the lenght of m
	4. Left pointer points to nums1 and 2nd pointer to nums2
	5. If left value is less than or equal to right value move left pointer
	6. If left value is greater than right value swap and move left pointer
	7. After m iterations copy all elements from nums2 into nums1 from position m
*/

    private int[] mergeSortedArray(int[] nums1,int m,int[] nums2,int n){
        if(n==0)return nums1;
        if(m==0) {
        }

        int left=m-1, right=n-1;
        int i=nums1.length-1;
        for(;i>0;i--){
            if(left>=0 && right>=0) {
                if (nums1[left] > nums2[right]) {
                    nums1[i] = nums1[left--];
                }
                else nums1[i]=nums2[right--];
            }

        }
        if(right>=0){
            System.arraycopy(nums2,0,nums1,0,right+1);
        }
        return nums1;
    }
}
