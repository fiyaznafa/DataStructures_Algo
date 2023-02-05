package Maps;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNoOccurneceTest {

    @Test
    public void test1(){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(isUniqueOccurence(nums));
    }

    @Test
    public void test2(){
        int[] nums={1,2,2,1,1,3};
        System.out.println(isUniqueOccurence(nums));
    }

    private boolean isUniqueOccurence(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int n:nums) map.put(n,map.getOrDefault(n,0)+1);
        for(int n:map.values()){
            if(!set.add(n))return false;
        }
        return true;
    }
}
