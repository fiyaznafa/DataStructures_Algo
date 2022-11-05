package Maps;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramIndicesStringTest {

    @Test
    public void test1(){
        String s="scbaebabacd" ,p = "abc";
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(6);
        Assert.assertEquals(list,indicesOfAnagramOptimize(s,p));
    }

    @Test
    public void test2(){
        String s="abab", p = "ab";
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        Assert.assertEquals(list,indicesOfAnagram(s,p));
    }

/*
	Pseudocode
	1. Add the characters of p to pmap
	2. Add the character of s to sMap
	3. If the counter is increased to more than length of the p map , compare p map and s map, if equal add i-plength to list
	4. Add the next character and remove the previous character (i-plength)
	5. Compare p map and sMap, if they are equal, add the index i-p index to the map
	6. Return the list
*/


    public List<Integer> indicesOfAnagram(String s, String p) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        char c;
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (i < p.length()) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (pMap.equals(sMap)) list.add(i - p.length() + 1);
            } else {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (sMap.get(s.charAt(i - p.length())) == 1)
                    sMap.remove(s.charAt(i - p.length()));
                else
                    sMap.put(s.charAt(i - p.length()), sMap.get(s.charAt(i - p.length())) - 1);

                if (pMap.equals(sMap)) list.add(i - p.length() + 1);
            }

        }
        return list;
    }

    public List<Integer> indicesOfAnagramOptimize(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length()<p.length())return list;
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        char c;
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            c=s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        if (pMap.equals(sMap)) list.add(0);

        for (int i = p.length(); i < s.length(); i++) {
            c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            char key = s.charAt(i - p.length());
            if (sMap.get(key) == 1)
                sMap.remove(key);
            else
                sMap.put(key, sMap.get(key) - 1);
            if (pMap.equals(sMap)) list.add(i - p.length() + 1);
        }
        return list;
}


}
