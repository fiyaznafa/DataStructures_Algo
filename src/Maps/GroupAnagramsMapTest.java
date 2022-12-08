package Maps;

import org.junit.Test;

import java.util.*;

public class GroupAnagramsMapTest {

    @Test
    public void test1(){
      String[] str ={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }

    private List<List<String>> groupAnagrams(String[] str) {
        List<List<String>> groupedList = new ArrayList<>();
        if(str.length==0)return groupedList;
        HashMap<String,List<String>> map = new HashMap<>();

        for (String eacString:str) {
            String key =calculateAsciiEquivaluent(eacString);
            List<String> temp;
            if(!map.containsKey(key)) temp = new ArrayList<>();
            else  temp = map.get(key);
            temp.add(eacString);
            map.put(key,temp);
        }
         groupedList.addAll(map.values());
        return groupedList;
}

    int[] arr = new int[26];
    private String calculateAsciiEquivaluent(String eachString) {
        Arrays.fill(arr,0);
        for (char c:eachString.toCharArray()) {
            arr[c-'a']++;
        }
        return Arrays.toString(arr);
    }

}
