package Maps;

import org.junit.Test;
import org.testng.Assert;

import java.util.*;

public class RingsAndRodsTest {

    @Test
    public void test1(){
        String rings ="B0B6G0R6R0R6G9G6";
        Assert.assertEquals(2,noOfRodsOptimized(rings));
    }

    @Test
    public void test2(){
        String rings ="B0R0G0R9R0B0G0";
        Assert.assertEquals(1,noOfRod(rings));
    }

    @Test
    public void test3(){
        String rings ="G4";
        Assert.assertEquals(0,noOfRodsOptimized(rings));
    }

    private int noOfRod(String rings) {
        Map<Character,Set<Character>> map = new HashMap<>();
        Set<Character> noOfRings = new HashSet<>();
        char c ;

        Set<Character> set;
        for (int i = 1; i < rings.length(); i+=2) {
            c=rings.charAt(i-1);
            if(!map.containsKey(rings.charAt(i)))  set=new HashSet<>();
            else  set=map.get(rings.charAt(i));
            set.add(c);
            map.put(rings.charAt(i), set);
            if(map.get(rings.charAt(i)).size()==3)noOfRings.add(rings.charAt(i));
        }
        return noOfRings.size();
     }

     private int noOfRodsOptimized(String rings){
        int noRods=0;
        char rod;
        char ring;
        Map<Character,Set<Character>> map = new HashMap<>();
         for (int i = 1; i <rings.length() ; i+=2) {
                rod=rings.charAt(i);
                ring=rings.charAt(i-1);
                map.putIfAbsent(rod,new HashSet<>());
                if(map.get(rod).add(ring))
                    if(map.get(rod).size()==3)noRods++;
         }
         return noRods;
     }

}
