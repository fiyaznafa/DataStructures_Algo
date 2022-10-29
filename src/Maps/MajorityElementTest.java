package Maps;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElementTest {
    /*
https://leetcode.com/problems/majority-element/
11:24

*/

    @Test
    public void test1(){
        int[] nums ={3,2,3};
        Assert.assertEquals(3,majorityElementUsingMap(nums));
    }


    @Test
    public void test2(){
        int[] nums ={3,2,3,2,3,3,4,3,5};
        Assert.assertEquals(3,majorityElementUsingMap(nums));
    }


    @Test
    public void test3(){
        int[] nums ={1,1,1,1,1,1};
        Assert.assertEquals(1,majorityElement(nums));
    }



/*Psuedocode
	Brute force
	1. Iterate till the end of the loop - i=0 -> i<nums.length-1
	2. Take a second loop , iterate from the element and count the no of times number at i repeated , j=i -> j<nums.length
	3. If count of element >n/2 return number at i;
*/



    private int majorityElement(int[] nums){
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[i]==nums[j])count++;
            }
            if(count> nums.length/2)return nums[i];
            count=0;
        }
        return 0;
    }


/*
	Pseudocode
	Using Hashmap
	1. Add each number to hashmap
	2. Check the count of each character , if greater than nums.length/2 return
*/

    private int majorityElementUsingMap(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int i=0;
        while(i<nums.length){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            i++;}

        Set<Integer> set =map.keySet();

        for (Integer entry:set) {
            if(map.get(entry)> nums.length/2)return entry;
        }
        return 0;
    }

}
