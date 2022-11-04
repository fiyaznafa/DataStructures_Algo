package twoPointer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionArrayIITest {
    //https://leetcode.com/problems/intersection-of-two-arrays-ii/
/*
 Test Data
 1)nums1 = [1,2,2,1], nums2 = [2,2]
 2)nums1=[4,9,5], nums2 = [9,4,9,8,4]
 3)nums1=[], nums2=[3,5,6,0]
*/

/*
	Pseudocode
	1. Sort both the array
	2. Iterate till end of either the array
	3. If value at nums1>nums2 , nums2++
	4. If value at nums2>nums1, nums1++
	5. If equal add to a list
*/

    @Test
    public void test1(){
        int[] nums1 ={1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString((intersectionArray(nums1,nums2))));
    }

    @Test
    public void test2(){
        int[] nums1 ={4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString((intersectionArray(nums1,nums2))));
    }

    @Test
    public void test3(){
        int[] nums1 ={1,2,2,1};
        int[] nums2 = {2};
        System.out.println(Arrays.toString((intersectionArray(nums1,nums2))));
    }

    private int[] intersectionArray(int[] nums1, int[] nums2){
        if(nums1.length==0 || nums2.length==0) return new int[]{};

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int left =0,right=0;
        while(left<nums1.length && right<nums2.length){
            if(nums1[left]>nums2[right])right++;
            else if(nums1[left]<nums2[right])left++;
            else {list.add(nums1[left]); left++;right++;}
        }
        int[] output = new int[list.size()];
        int i=0;
        for (int no:list)output[i++]=no;

        return output;
    }

}
