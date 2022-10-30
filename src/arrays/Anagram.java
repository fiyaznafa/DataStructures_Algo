package arrays;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Anagram {


    /*8:10
    Pseudo Code
    1. Validate the length of the two string matches, else return false
    2. For both string, Create hashmap with all the characters and add to map
    3. Validate both map are equal

    Done with 08:25
     */

    @Test
    public void test1(){
        String str1="anagram";
        String str2="nagaram";
        System.out.println(checkAnagramAscii(str1,str2));
    }

    @Test
    public void test2(){
        String str1="cat";
        String str2="rat";
        System.out.println(checkAnagramAscii(str1,str2));
    }

    @Test
    public void test3(){
        String str1="tea";
        String str2="nagaram";
        System.out.println(checkAnagramAscii(str1,str2));
    }

    @Test
    public void test4(){
        String str1="accca";
        String str2="aaaccs";
        System.out.println(checkAnagramAscii(str1,str2));
    }



    private boolean checkAnagram(String str1, String str2) {

        if(str1.length()!=str2.length()) return false;
        Map<Character, Integer> map1;
        Map<Character, Integer> map2;

        map1=calculateOccurence(str1);
        map2=calculateOccurence(str2);

        if(map1.equals(map2)) return true;
        else return false;
    }

    private Map<Character,Integer> calculateOccurence(String str1) {
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<str1.length();i++){
            map.put(str1.charAt(i),map.getOrDefault(str1.charAt(i),0)+1);
        }
        return  map;
    }

    private boolean checkAnagramAscii(String s,String t){
        if(s.length()!=t.length())return false;
        int[] count = new int[26];
        for (int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for (int i=0;i<s.length();i++){
            if(count[s.charAt(i)-'a']>0)return false;
        }
        return true;
    }



}
