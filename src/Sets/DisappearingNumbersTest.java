package Sets;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class DisappearingNumbersTest {

    @Test
    public void test1(){
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> input = new ArrayList<>();
        input.add(5);
        input.add(6);
        Assert.assertEquals(input,disappearingNums(nums));
    }

    @Test
    public void test2(){
        int[] nums={1,1};
        List<Integer> input = new ArrayList<>();
        input.add(2);
        Assert.assertEquals(input,disappearingNums(nums));
    }

    @Test
    public void test3(){
        int[] nums={2};
        List<Integer> input = new ArrayList<>();
        input.add(1);
        Assert.assertEquals(input,disappearingNums(nums));
    }

    @Test
    public void test4(){
        int[] nums={1};
        Assert.assertEquals(new ArrayList<>(),disappearingNums(nums));
    }

    private List<Integer> disappearingNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int no:nums) set.add(no);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            if(!set.contains(i+1))list.add(i+1);
        }
        return list;
    }

}
