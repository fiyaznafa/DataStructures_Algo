package Sets;

import org.junit.Test;
import org.testng.Assert;

import java.util.HashSet;
import java.util.Set;

public class SumUniqueElementsTest {
        @Test
    public void test1(){
        int[] nums={1,2,3,2};
        Assert.assertEquals(4,uniqueSumOptimized(nums));
    }

    @Test
    public void test2(){
        int[] nums={1,1,1,1};
        Assert.assertEquals(0,uniqueSumOptimized(nums));
    }

    @Test
    public void test3(){
        int[] nums={1,2,3,4,5};
        Assert.assertEquals(15,uniqueSumOptimized(nums));
    }
    /*
	Pseudocode
	1. Create two Set 1-Duplicate 1-Store Unique Elements
	2. If element is not present in duplicate then add to Unique and add Sum
	3. If not able to add then remove from sun and add to duplicate
*/

    private int uniqueSum(int[] nums){
        int sum=0;
        Set<Integer> duplicate = new HashSet<>();
        Set<Integer> unique = new HashSet<>();
        for(int num:nums){
            if(!duplicate.contains(num)&&unique.add(num))sum+=num;
            else if(duplicate.contains(num));
            else {
                duplicate.add(num);
                unique.remove(num);
                sum-=num;
            }
        }
        return sum;
    }

    /*
        Pseudocode Optimized (Reducing space)
        1. Create an int array of 100
        2. Iterate over array , and check if the no is 0
        3. If arr[num] is zero then increment the array and add to sum
     */
    private int uniqueSumOptimized(int[] nums){
        int[] arr = new int[100];
        int sum=0;
        for (int num:nums){
            if(arr[num]==0){
                sum+=num;
                arr[num]++;
            }
            else if(arr[num]==1){
                sum-=num;
                arr[num]++;
            }
        }
        return sum;
    }
}