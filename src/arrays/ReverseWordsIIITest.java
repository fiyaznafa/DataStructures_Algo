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
        System.out.println(reverseWordsIII(s));
    }

    @Test
    public void test2(){
        String  s ="God Ding";
        System.out.println(reverseWordsIII(s));
    }

    @Test
    public void test3(){
        String  s ="Good";
        System.out.println(reverseWordsIII(s));
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
        for(;i>=0;i--) sb.append(str.charAt(i));
        return sb.toString();
    }

    private String reverseWordsII(String str){
        int left =0,right =1;
        StringBuilder sb = new StringBuilder();
        while (right<str.length()){
            if(str.charAt(right)==' '){
                sb.append(reverseString(str.substring(left,right)));
                sb.append(' ');
                left=right+1;
            }
            if(right==str.length()-1) sb.append(reverseString(str.substring(left,right+1)));

            right++;
        }
        return sb.toString();
    }


    private String reverseWordsIII(String str){
        int left =0,right =1,index = 0;
        char temp;
        char[] chars = str.toCharArray();
        while (right<str.length()){
            if(str.charAt(right)==' ' || right==str.length()-1){
                if(right==str.length()-1)index=right;
                else index=right-1;
                while (index>left){
                    temp=chars[index];
                    chars[index--]=chars[left];
                    chars[left++]=temp;
                }
                left=right+1;
                right++;
            }
            right++;
        }
        return new String(chars);
    }

}
