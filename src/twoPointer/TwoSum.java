package twoPointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    @Test
    public void test1(){
        int[] nums ={2,7,11,15};
        int target =9;
        System.out.println(Arrays.toString(findingSumUsingMapOptimized(nums,target)));    }

    @Test
    public void test2(){
        int[] nums ={3,2,4};
        int target=6;
        System.out.println(Arrays.toString(findingSumUsingMapOptimized(nums,target)));
    }

    @Test
    public void test3(){
        int[] nums ={2,7,11,15};
        int target =9;
        System.out.println(Arrays.toString(findingSumUsingMapOptimized(nums,target)));    }

    @Test
    public void test4(){
        int[] nums ={3,2,4};
        int target=6;
        System.out.println(Arrays.toString(findingSumUsingMapOptimized(nums,target)));
    }

    /*
        Using sorting Pseudo Code
        Two pointer technique
        1. 1st Pointer should be pointing to 1s and 2nd to the next element.
        2. If sum is not equal move the 2nd pointer to the next position.
        3. When 2nd pointer reaches the end move the 1st pointer ahead

        Using Map
        1. Add all characters to map with indices
        2. Iterate through loop
        3. Check if element is present in map for sum - ith element
        4.  Return index of i element and index of (sum - ith element)
     */

    private int[] findTwoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] indices=  new int[2];
        int i=0,  j=nums.length-1, sum;
        while(i<j){
            sum=nums[i]+nums[j];
        if(sum == target){
            indices[0]=i;
            indices[1]=j;
            return indices;
        }
        else if (sum>target) j--;
        else i++;
        }
        return indices;
    }

    private int[] findtwoSumUsingMap(int[] nums,int target){
        int[] indices = new int[2];
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length ; i++) {
            if(map.containsKey(target - nums[i])&& i!=map.get(target-nums[i])) {
                indices[0] = i;
                indices[1] = map.get(target - nums[i]);
            }
        }
        return indices;
    }



    private int[] findingSumUsingMapOptimized(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length ; i++) {
            if(map.containsKey(target - nums[i])&& i!=map.get(target-nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
