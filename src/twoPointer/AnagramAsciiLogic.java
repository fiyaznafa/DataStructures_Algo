package twoPointer;


import org.junit.Test;

import java.util.Arrays;

public class AnagramAsciiLogic {

    /*
    Pseudo Code/Logic
    1. Create and int array of size
    2. Navigate to the string and calculate value of the each char
    3. Increment the count of each character in corresponding int array
    4. Compare both the int array
     */

    @Test
    public void test1(){
    String t ="anagram";
    String s ="nagaram";
    System.out.println(isAnagram(t,s));
    }

    @Test
    public void test2(){
        String str1="cat";
        String str2="rat";
        System.out.println(isAnagram(str1,str2));
    }

    @Test
    public void test3(){
        String str1="tea";
        String str2="nagaram";
        System.out.println(isAnagram(str1,str2));
    }

    @Test
    public void test4(){
        String str1="accca";
        String str2="aaaccs";
        System.out.println(isAnagram(str1,str2));
    }

    @Test
    public void test5(){
        String t ="aabbaacc";
        String s ="ccaabbaa";
        System.out.println(isAnagram(t,s));
    }

    private boolean isAnagram(String t, String s) {
        if(t.length()!=s.length()) return false;
            int[] x = anagramTest(t);
            int[] y = anagramTest(s);
        if(Arrays.equals(x,y))
            return true;
        else
            return false;
    }

    private int[] anagramTest(String s) {
        int[] x = new int[128];
        for(int i=0;i<s.length();i++){
             x[s.codePointAt(i)]+=1;
        }
        return x;
    }


}
