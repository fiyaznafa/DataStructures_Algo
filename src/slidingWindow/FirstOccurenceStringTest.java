package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class FirstOccurenceStringTest {

    // 28.Find the Index of the First Occurrence in a String
//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

    @Test
    public void test1(){
        String haystack = "sadbutsad";
        String needle="sad";
        Assert.assertEquals(0,firstOccurence(haystack,needle));
    }


    @Test
    public void test2(){
        String haystack = "leetcode";
        String needle="leeto";
        Assert.assertEquals(0,firstOccurence(haystack,needle));
    }

/*
	Psuedocode
	1. Iterate the haystack string until the char in haystack mathces the first char at needle
	2. If it matches , Iterate the length of the needle and compare each char , if all char matches return the index of haystack
	3. If not equal break out of the loop
*/

    private int firstOccurence(String haystack,String needle){
        int hayPointer=0,needPointer=0,temp=0;
        while(hayPointer<haystack.length()){
            if(haystack.charAt(hayPointer)==needle.charAt(needPointer)){
                temp=hayPointer;
                while(needPointer<needle.length()){
                    if(haystack.charAt(temp)==needle.charAt(needPointer)){
                        needPointer++;
                        temp++;
                        if(needPointer==needle.length())return hayPointer;
                    }
                    else {needPointer=0;hayPointer++; break;}
                }
            }else hayPointer++;
        }
        return -1;
    }






}
