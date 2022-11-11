package Maps;

import org.testng.annotations.Test;

import java.util.*;

public class UncommonWordsTest {

    @Test
    public void test1(){
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        System.out.println(Arrays.toString(uncommonWordOptimized(s1,s2)));
    }

    @Test
    public void test2(){
        String s1 = "apple apple", s2 = "banana";
        System.out.println(Arrays.toString(uncommonWordOptimized(s1,s2)));
    }

    /*
        Pseudocode
        1. Create two map add count of each word of sentence in respective map
        2. If count is 1 and does not contain in the second map add to res
     */

    private String[] uncommonWord(String s1, String s2) {
        Map<String,Integer> s1Map = new HashMap<>();
        Map<String,Integer> s2Map = new HashMap<>();
        for (String s:s1.split(" ")) s1Map.put(s,s1Map.getOrDefault(s,0)+1);
        for (String s:s2.split(" ")) s2Map.put(s,s2Map.getOrDefault(s,0)+1);

        Set<String> output = new HashSet<>();

        for (String s:s1Map.keySet()) if(s1Map.get(s)==1 && !s2Map.containsKey(s))output.add(s);
        for (String s:s2Map.keySet()) if(s2Map.get(s)==1 && !s1Map.containsKey(s))output.add(s);

        String[] outputArr = new String[output.size()];
        int i=0;
        for (String str:output) {
            outputArr[i++]=str;
        }
        return outputArr;
    }

    /*
        Optimized Pseudocode
        1. Add words of both sentence two map and return which word has count as 1
     */

    private String[] uncommonWordOptimized(String s1, String s2) {
        Map<String,Integer> map = new HashMap<>();
        for (String s:s1.split(" ")) map.put(s,map.getOrDefault(s,0)+1);
        for (String s:s2.split(" ")) map.put(s,map.getOrDefault(s,0)+1);

        Set<String> set = new HashSet<>();

        for (String s:map.keySet()) if(map.get(s)==1)set.add(s);

        String[] outputArr = new String[set.size()];
        int i=0;
        for (String str:set) {
            outputArr[i++]=str;
        }
        //return set.toArray(new String[0]);
        return outputArr;
    }

}
