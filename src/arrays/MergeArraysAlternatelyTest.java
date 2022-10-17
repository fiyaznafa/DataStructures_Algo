package arrays;

import org.junit.Test;

public class MergeArraysAlternatelyTest {

    //https://leetcode.com/problems/merge-strings-alternately/

    @Test
    public void test1(){
        String word1="abc";
        String word2="pqr";
        System.out.println(mergeStringAlternately(word1,word2));
    }

    @Test
    public void test2(){
        String word1="abcdef";
        String word2="pqr";
        System.out.println(mergeStringAlternately(word1,word2));
    }

    @Test
    public void test3(){
        String word1="abcdef";
        String word2="";
        System.out.println(mergeStringAlternately(word1,word2));
    }

/*
	PesudoCode
	1. If either string is empty return other string
	2. Iterate through each character of both words and add to a stringbuilder
	3. Add until end of any of the words
	4. Check if any words length is not traversed, copy rest of the characters into the stringbuilder
	5. Return the stringbuilder
*/

    private String mergeStringAlternately(String word1,String word2){
        if(word1.length()==0)return word2;
        if(word2.length()==0)return word1;

        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<word1.length() && i<word2.length()){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        if(i<word1.length())sb.append(word1.substring(i));
        if(i<word2.length())sb.append(word2.substring(i));

        return sb.toString();
    }

}
