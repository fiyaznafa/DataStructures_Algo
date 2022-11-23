package Stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class BackSpaceStringTest {

    //https://leetcode.com/problems/backspace-string-compare/description/

    @Test
    public void test1(){
        String s = "ab#c", t = "ad#c";
        Assert.assertTrue(backspaceCompare(s,t));
    }

    @Test
    public void test2(){
        String  s = "ab##", t = "c#d#";
        Assert.assertTrue(backspaceCompare(s,t));
    }

    @Test
    public void test3(){
        String  s = "a#c", t = "b";
        Assert.assertFalse(backspaceCompare(s,t));
    }

    @Test
    public void test4(){
        String  s = "#c", t = "c";
        Assert.assertTrue(backspaceCompare(s,t));
    }


/*
	Pseudocode - Using stack
	1. Add the char to stack
	2. If char is #, pop the previous char
	3. else push the char
	4. Compare both the stack
	5. If equal return true, else return false;
*/

    private boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='#') {if (!stack1.empty()) stack1.pop();}
            else stack1.push(c);
        }
        for(char c:t.toCharArray()){
            if(c=='#') {if (!stack2.empty()) stack2.pop();}
                else stack2.push(c);
        }
        return stack1.equals(stack2);
    }

}
