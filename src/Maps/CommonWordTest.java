package Maps;

import org.junit.Test;

import java.util.*;

public class CommonWordTest {

    //https://leetcode.com/problems/most-common-word/description/

    @Test
    public void test1(){
        String paragraph="Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned ={"hit"};
        System.out.println(mostCommonWord(paragraph,banned));
    }

    @Test
    public void test2(){
        String paragraph="a.";
        String[] banned ={};
        System.out.println(mostCommonWord(paragraph,banned));
    }

/*
	1. Add all the banned words to a Set
	2. Split the string with a regex \w
	3. Iterate the string array
	4. Add the string to map if it is not in the list
	5. Sort the KeySet using collections sort, with values from the map
*/

    private String mostCommonWord(String paragraph,String[] banned){
        Set<String> set = new HashSet<>();
        Collections.addAll(set, banned);

        String[] allWords =paragraph.split("\\W+");
        HashMap<String,Integer> map = new HashMap<>();
        for(String eachWord : allWords){
            if(!set.contains(eachWord.toLowerCase()))map.put(eachWord.toLowerCase(),map.getOrDefault(eachWord.toLowerCase(),0)+1);
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        return list.get(list.size()-1).getKey();
    }
}
