package arrays;

import org.junit.Test;

public class FaultySensorTest {

    //https://leetcode.ca/all/1826.html#:~:text=An%20experiment%20is%20being%20conducted,collected%20by%20the%20two%20sensors.
//https://leetcode.com/problems/faulty-sensor/

/*
Test data
1. sensor1 = [2,3,4,5], sensor2 = [2,1,3,4]
2. sensor1 = [2,2,2,2,2], sensor2 = [2,2,2,2,5]
3. sensor1 = [2,3,2,2,3,2], sensor2 = [2,3,2,3,2,7]
*/

    /*
        Pseudocode
        1. Using one pointer on sensor1 and 2nd pointer on sensor2 iterate the arrays
        2. If left = right , continue
        3. If left !=  right , check conditions
            if(left = right +1 & right!=left+1 )return 1
            else if(right = left+1) return 2
        4. If iteration is complete then it cannot be determined which sensor is faulty
    */
    @Test
    public void test1(){
        int[] nums1={2,3,4,5};
        int[] nums2={2,1,3,4};
        System.out.println(findFaultySensor(nums1,nums2));
    }

    @Test
    public void test2(){
        int[] nums1={2,2,2,2,2};
        int[] nums2={2,2,2,2,5};
        System.out.println(findFaultySensor(nums1,nums2));
    }

    @Test
    public void test3(){
        int[] nums1={2,3,2,2,3,2};
        int[] nums2={2,3,2,3,2,7};
        System.out.println(findFaultySensor(nums1,nums2));
    }

    @Test
    public void test4(){
        int[] nums1={2,3,2,2,3,2};
        int[] nums2={2,3,2,2,3,2};
        System.out.println(findFaultySensor(nums1,nums2));
    }


    private int findFaultySensor(int[] nums1,int[] nums2){
        int left=0,right=0;
        while(left<nums1.length-1 && right <nums2.length){
            if(nums1[left]!=nums2[right]){
                if((nums1[left]==nums2[right+1] )&& (nums2[right]!=nums1[left+1]))
                    return 1;
                else if(nums2[right]==nums1[left+1])
                    return 2;
            }
            left++;right++;
        }
        return -1;
    }
}
