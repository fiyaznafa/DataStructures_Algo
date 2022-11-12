package Sets;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringNonRepeatingCharTest {
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

/*
	Pseudocode - Two pointers
	1. Add elements to set
	2. If element is already in set , move the left pointer until you remove the character.
	3. Keep a temporary variable to count the length
*/

    @Test
    public void test1(){
        String s="abcabcbb";
        System.out.println(longestSubStringOptimized(s));
    }


    @Test
    public void test2(){
        String s="bbbbb";
        System.out.println(longestSubString(s));
    }

    @Test
    public void test3(){
        String s="pwwkew";
        System.out.println(longestSubStringOptimized(s));
    }

    private int longestSubString(String s){
        int left =0, right =0,maxlength=0;
        Set<Character> set = new HashSet<>();
        while(right<s.length()){
            while (set.contains(s.charAt(right)))set.remove(s.charAt(left++));
            set.add(s.charAt(right++));
            maxlength=Math.max(maxlength,right-left);
        }
        return maxlength;
    }


    private int longestSubStringOptimized(String s){
        int maxLength=0;
        int[] arr= new int[256];
        for (int i = 0,j=0; i <s.length() ; i++) {
            if(arr[s.charAt(i)]==1){
                while(arr[s.charAt(i)]==1)arr[s.charAt(j++)]--;
            }
            arr[s.charAt(i)]++;
            maxLength=Math.max(maxLength,i-j+1);
        }
        return maxLength;
    }

}
