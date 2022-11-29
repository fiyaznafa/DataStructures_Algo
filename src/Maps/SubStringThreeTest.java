package Maps;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubStringThreeTest {

    @Test
    public void test1(){
        String str ="xyzzaz";
        System.out.println(countGoodSubstringsSet(str));
    }

    @Test
    public void test2(){
        String str ="aababcabc";
        System.out.println(countGoodSubstringsSet(str));
    }


    /*
          Pseudocode
          1. Add each character to Map till length<2
              i. if already present increase the count
          2. Add the rest of the char add to map
          3. Remove the i-k+1 char
          4. Check map size , if map size if equal to 3 increment the count
      */
    public int countGoodSubstrings(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<3;i++)
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        if(map.size()==3)count++;

        for(int i=3;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            if(map.get(s.charAt(i-3))==1)map.remove(s.charAt(i-3));
            else map.put(s.charAt(i-3),map.get(s.charAt(i-3))-1);

            if(map.size()==3)count++;
        }

        return count;
    }


    public int countGoodSubstringsSet(String s) {
        Set<Character> set = new HashSet<>();
        int start=0,count=0;
        for (int i=0;i<s.length();i++) {
            //aababcabc
            while(!set.add(s.charAt(i)))set.remove(s.charAt(start++));
            if(set.size()==3){
                count++;
                set.remove(s.charAt(start++));
            }
        }
        return  count;
    }
}
