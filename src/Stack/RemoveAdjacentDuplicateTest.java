package Stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class RemoveAdjacentDuplicateTest {

    // https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
//Remove All Adjacent Duplicates In String
// 08:10  08:24

    @Test
    public void test1(){
        String s ="abbaca";
        Assert.assertEquals("ca",removeDuplicates(s));
    }

    @Test
    public void test2(){
        String s ="abba";
        Assert.assertEquals("",removeDuplicates(s));
    }

    @Test
    public void test3(){
        String s ="abcd";
        Assert.assertEquals("abcd",removeDuplicates(s));
    }


    @Test
    public void test4(){
        String s ="abbbbbccdccc";
        System.out.println(removeDuplicates(s));
        System.out.println(removeAllDuplicates(s));
    }

    @Test
    public void test5(){
        String s ="aaadd";
        System.out.println(removeDuplicates(s));
        System.out.println(removeAllDuplicates(s));
    }




/*
	Pseudocode
	1. If character at top of stack is not same as next character push
	2. If character is equal then remove the character and check the next character

	08:19
*/


    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()==c)stack.pop();
            else stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())sb.append(stack.pop());
        return sb.reverse().toString();

        //08:22
    }


    /*
        Pseudocode
        1. If char in stack is same as the next char -
        keep checking next char until they are same and pop the char
        2. If not same push to stack
     */
    public String removeAllDuplicates(String s){
        if(s.length()==1 || s.length()==0)return s;
        Stack<Character> stack = new Stack<>();
        char c;
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek()!=s.charAt(i))stack.push(s.charAt(i));
            else if(!stack.isEmpty() && stack.peek()==s.charAt(i)){
                while(stack.peek()==s.charAt(i) && i<s.length()-1)i++;
                stack.pop();
                if(i<s.length())stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())sb.append(stack.pop());
        return sb.reverse().toString();
    }

}
