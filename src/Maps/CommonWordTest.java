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
        int count,max=Integer.MIN_VALUE;
        String commonWord="";
        for(String eachWord : allWords){
            if(!set.contains(eachWord.toLowerCase())){
                count= map.getOrDefault(eachWord.toLowerCase(), 0)+1;
                if(count>max){
                    max=count;
                    commonWord=eachWord.toLowerCase();
                }
                map.put(eachWord,count);
            }

        }
        return commonWord;
    }
}
