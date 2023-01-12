package Recursion;

import org.testng.annotations.Test;

import java.util.Arrays;

public class LongestSubStringAtLeastKTest {

    @Test
    public void test1(){
        String s="aaabb";
        int k=2;
        System.out.println(longestKRepeating(s,k));
    }

    @Test
    public void test2(){
        String s="aaabb";
        int k=3;
        System.out.println(longestKRepeating(s,k));
    }

    @Test
    public void test3(){
        String s="ababbc";
        int k=2;
        System.out.println(longestKRepeating(s,k));
    }

    @Test
    public void test4   (){
        String s="ababacb";
        int k=3;
        System.out.println(longestKRepeating(s,k));
    }



    /*
        Pseudocode
        1. Find the char which has count less than k - index
        2. Call LongestKRepeating recursively - with subString until index and index+1 until end of subString
        3. Breaking condition , if  size of substring is less than k, return 0 or if no char has count less than k return string length
     */
    private int longestKRepeating(String s, int k) {
        return findLongest(s,0,s.length(),k);
    }

    int[] count = new int[26];
    private int findLongest(String s,int start,int end,int k){
        if(end<k)return 0;
        Arrays.fill(count,0);
        int index=-1;
        for (int i = start; i <end ; i++) count[s.charAt(i)-'a']++;
        for (int i = start; i <end ; i++) {
            if(count[s.charAt(i)-'a']<k) {
                index=i;
                break;
            }
        }
        if(index==-1)return end-start;
        else{
            return  Math.max(findLongest(s,start,index,k),findLongest(s,index+1,end,k));
        }
    }
}
