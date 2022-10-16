import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayPartitionTest {

    //https://leetcode.com/problems/array-partition/


    @Test
    public void test1(){
        int[] nums ={1,4,3,2};
        Assert.assertEquals(4,arrayPartition(nums));
    }

    @Test
    public void test2(){
        int[] nums ={6,2,6,5,1,2};
        Assert.assertEquals(9,arrayPartition(nums));

    }

    /* 	Pseudocode
     *	1. Sort the array
     *	2. Traverse through array
     *	3. Find Min of two consecutive elements and add to sum
     */

    private int arrayPartition(int[] nums){
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<=nums.length-2;i+=2){
            sum+=Math.min(nums[i],nums[i+1]);
        }
        return sum;
    }

}
