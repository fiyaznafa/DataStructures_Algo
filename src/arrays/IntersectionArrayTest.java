package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionArrayTest {
    //https://leetcode.com/problems/intersection-of-two-arrays/

    @Test
    public void test1(){
        int[] nums1 ={1,2,2,1};
        int[] nums2 ={2,2};
        Assert.assertArrayEquals(new int[]{2},intersectionTwoArrays(nums1,nums2));
    }

    @Test
    public void test2(){
        int[] nums1 ={1,2,2,1};
        int[] nums2 ={};
        Assert.assertArrayEquals(new int[]{},intersectionTwoArrays(nums1,nums2));
    }

    @Test
    public void test3(){
        int[] nums1 ={1,2,2,1};
        int[] nums2 ={4,3,5,7};
        Assert.assertArrayEquals(new int[]{},intersectionTwoArrays(nums1,nums2));
    }


    private int[] intersectionTwoArrays(int[] nums1,int[] nums2){
        if(nums1.length==0||nums2.length==0) return new int[] {};
        else{
            Set<Integer> set = new HashSet<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int left=0,right=0;
            while(left<nums1.length && right<nums2.length){
                if(nums1[left]==nums2[right]) {
                    set.add(nums1[left++]);
                    right++;
                }
                else if(nums1[left]<nums2[right]) left++;
                else right++;
            }
            int[] output= new int[set.size()];
            int j=0;
            for(Integer i : set){
                output[j++]=i;
            }
            return output;
        }
    }
}
