package Maps;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharTest {
    //https://leetcode.com/problems/first-unique-character-in-a-string/

    @Test
    public void test1(){
        String input ="leetcode";
        Assert.assertEquals(0,firstUniqueString(input));
    }

    @Test
    public void test2(){
        String input ="loveleetcode";
        Assert.assertEquals(2,firstUniqueString(input));
    }

    @Test
    public void test3(){
        String input ="aabb";
        Assert.assertEquals(-1,firstUniqueString(input));
    }


/*
	Pseudocode
	1. Put all chars in map
	2. check which char has 1
	3. Return the index
*/


    private int firstUniqueString(String s){

        Map<Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray())map.put(c,map.getOrDefault(c,0)+1);

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1)return i;
        }
        return -1;

    }

}
