package Maps;

import org.junit.Test;
import org.testng.Assert;

import java.util.*;

public class NoOfGoodPairsTest {

    @Test
    public void test1(){
       int[] nums={1,2,3,1,1,3};
        Assert.assertEquals(4,noOfGoodPairsAscii(nums));
    }

    @Test
    public void test2(){
        int[] nums={1,1,1,1};
        Assert.assertEquals(6,noOfGoodPairsAscii(nums));
    }

    @Test
    public void test3(){
        int[] nums={1,2,3};
        Assert.assertEquals(0,noOfGoodPairs(nums));
    }

    /*
        Pseudocode Bruteforce
        1. Add occurrence of each integer and add to map
        2. If occurrence of integer is greater than 1.
        3. Then calculate the sum
     */
    private int noOfGoodPairs(int[] nums) {
        int count=0;
       Map<Integer,Integer> map = new HashMap<>();
        for(Integer num:nums)map.put(num,map.getOrDefault(num,0)+1);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> value:entries) {
            if(value.getValue()>1){
                count+=(value.getValue()*(value.getValue()-1))/2;
            }
        }
        return count;
    }

    /*
        Pseudocode
        1. As constraint mentions nos will be uptp 100 , take countArray of size 101
        2. Iterate through the numbers and increase the countArray value at numbers position
        3. Calculate the sum at the end
     */

    private int noOfGoodPairsAscii(int[] nums){
        int[] arr = new int[101];
        int sum=0;
        for (int num : nums) {
            arr[num]++;
        }
        for (int j : arr) {
            if (j > 1) sum += (j * (j - 1)) / 2;
        }
        return sum;
    }

}
