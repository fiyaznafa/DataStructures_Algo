package Maps;

import org.junit.Test;

import java.util.*;

public class GroupAnagramTest {
    //49. Group Anagrams
//https://leetcode.com/problems/group-anagrams/

    @Test
    public void test1(){
        String[] str ={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagram(str));
    }

    @Test
    public void test2(){
        String[] str ={""};
        System.out.println(groupAnagram(str));
    }

    @Test
    public void test3(){
        String[] str ={"a"};
        System.out.println(groupAnagram(str));
    }


/*	
	Pseudocode
	1. Create a Map<String,List<String>>
	2. For each string put it in int array and return the string equivalent
	3. Check if map already contains the string calculated in step 2.
	4. If contains , then add string to the value
	5. If it does not contain , create a new key and the string
*/

    private List<List<String>> groupAnagram(String[] strs){
        List<List<String>> values =new ArrayList<>();
        if (strs.length==0)return values;
        Map<String, List<String>> allMap = new HashMap<>();
        for(String eachString:strs) {
           String asciEquivalentString = asciiEquiArray(eachString);
            if(!allMap.containsKey(asciEquivalentString)){
                List<String> list = new ArrayList<>();
                list.add(eachString);
                allMap.put(asciEquivalentString,list);
            }
            else {
                List<String> list;
                list = allMap.get(asciEquivalentString);
                list.add(eachString);
                allMap.put(asciEquivalentString,list);}
        }
        values.addAll(allMap.values());
        return values;
    }

    private String asciiEquiArray(String eachString) {
        int[] arr= new int[26];
        for (char c:eachString.toCharArray()) arr[c-'a']++;
        return Arrays.toString(arr);
    }
}
