package Maps;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNoOccurenceTest {

    @Test
    public void test1(){
        int[] arr={1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
    }

    @Test
    public void test2(){
        int[] arr={1,2};
        System.out.println(uniqueOccurrences(arr));
    }

    @Test
    public void test3(){
        int[] arr={-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(arr));
    }



    /*
            Pseudocode
            1. Add Frequencies to map
            2. Iterate over values and to Set
            3. If not able to add any ele return false , else return true
            */
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int no:arr)map.put(no,map.getOrDefault(no,0)+1);
            Set<Integer> set = new HashSet<>();
            for(int freq:map.values()){
                if(!set.add(freq))return false;
            }
            return true;
        }

}
