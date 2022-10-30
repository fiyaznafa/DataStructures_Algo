package arrays;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class NiceSubStringTest {
    //https://leetcode.com/problems/longest-nice-substring/

    @Test
    public void test1(){
      String str ="YazaAay";
        System.out.println(longestNiceSubstring(str));
    }


    @Test
    public void test2(){
        String str ="Bb";
        System.out.println(longestNiceSubstring(str));
    }

    @Test
    public void test3(){
        String str ="abCdE";
        System.out.println(longestNiceSubstring(str));
    }

    @Test
    public void test4(){
        String str ="xLeElzxgHzcWslEdgMGwEOZCXwwDMwcEhgJHLL";
        System.out.println(longestNiceSubstring(str));
    }


    private String longestNiceSubstring(String str) {
        if(str.length()<2)return "";
        Set<Character> set = new HashSet<>();
        for (char c:str.toCharArray()) set.add(c);
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue;
            String sub1 = longestNiceSubstring(str.substring(0, i));
            String sub2 = longestNiceSubstring(str.substring(i+1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return str;
    }
}
