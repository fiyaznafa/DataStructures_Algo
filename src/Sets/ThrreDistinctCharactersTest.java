package Sets;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class ThrreDistinctCharactersTest {
    //https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

    @Test
    public void test1(){
        String s="xyzzaz";
        Assert.assertEquals(1,subStringThreeChars(s));
    }

    @Test
    public void test2(){
        String s="aababcabc";
        Assert.assertEquals(4,subStringThreeChars(s));
    }

    /*
        Pseudocode
        Algorithm - sliding window (Map can also be used instead of set)
        1. Iterate through the string, add the first 3 char to map and check the size of map
        2. If size =3 increment count
        3. Iterate through the rest of the string
        4. each char and remove the i-3 char
        5. For every char added check if size of map is 3, increment the count
        6. Return count
     */


    private int subStringThreeChars(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int count=0;

        for (int i = 0; i <s.length() ; i++) {
            if(i>=3){
                if(map.get(s.charAt(i - 3))==1)map.remove(s.charAt(i-3));
                else map.put(s.charAt(i-3),map.get(s.charAt(i-3))-1);
            }
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            if(map.size()==3)count++;
        }
        return count;
    }
}
