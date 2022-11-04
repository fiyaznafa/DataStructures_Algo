package Maps;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ContansDuplucateIITest {

    @Test
    public void test1(){
      int[] nums = {1,2,3,1};
      int k = 3;
      Assert.assertTrue(containsDuplicate(nums,k));
    }

    @Test
    public void test2(){
        int[] nums = {1,0,1,1};
        int k = 1;
        Assert.assertTrue(containsDuplicate(nums,k));
    }

    @Test
    public void test3(){
        int[] nums = {1,2,3,1,2,3};
        int k = 1;
        Assert.assertFalse(containsDuplicate(nums,k));
    }

    private boolean containsDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int i=0;
        for (int no:nums) {
            if(!map.containsKey(no))map.put(no,i++);
            else if(map.containsKey(no) && i-map.get(no)<=k)return true;
            else map.put(no,i++);
        }
        return false;
    }


}
