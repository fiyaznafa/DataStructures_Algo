package Sets;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TwoSumUsingSetTest {

    @Test
    public void test1(){
        int[] nums={2,4,6,7,1,3};
        int sum=13;
        System.out.println(Arrays.toString(twoSumUsingSet(nums,sum)));
    }

    private int[] twoSumUsingSet(int[] nums, int sum) {
        Set<Integer> set = new HashSet<>();

        for (Integer n:nums) {
            if(set.contains(sum-n))return new int[]{sum-n,n};
            set.add(n);
        }
        return new int[] {};
    }
}
