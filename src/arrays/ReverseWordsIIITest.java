package arrays;

import org.junit.Test;

public class ReverseWordsIIITest {
//https://leetcode.com/problems/reverse-words-in-a-string-iii/

/*
	TestData
	1.Input: s = "Let's take LeetCode contest"
	  Output: "s'teL ekat edoCteeL tsetnoc"
	2.Input: s = "God Ding"
	  Output: "doG gniD"
	3.Input: s = "Good "
	  Output: " Good"
*/

    @Test
    public void test1(){
        String  s ="Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    @Test
    public void test2(){
        String  s ="God Ding";
        System.out.println(reverseWords(s));
    }

    @Test
    public void test3(){
        String  s ="Good";
        System.out.println(reverseWords(s));
    }

/*
	Pseudocode
	1. Split the String into words using string split
	2. For each work reverse it and to a string buffer
	3. For each word start a pointer from the end of the string and append to the string buffer
	4. Trim space at the end and return the string
*/

    public String reverseWords(String s){

        String [] splitStrings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String eachString: splitStrings ){
            sb.append(reverseString(eachString));
            sb.append(reverseString(" "));
        }
        return sb.toString().trim();
    }

    private String reverseString(String str){
        int i=str.length()-1;
        StringBuilder sb = new StringBuilder();
        for(;i>=0;i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
