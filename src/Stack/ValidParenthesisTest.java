package Stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ValidParenthesisTest {

    //https://leetcode.com/problems/valid-parentheses/

    @Test
    public void test1(){
        String s="()";
        Assert.assertTrue(isValid(s));
    }

    @Test
    public void test2(){
        String s="()[]{}";
        Assert.assertTrue(isValid(s));
    }

    @Test
    public void test3(){
        String s="}()[]{}";
        Assert.assertTrue(isValid(s));
    }



/*
	Pseudocode
	1. Check if first char is closing bracket, return false
	2. If it is opening bracket keep adding
	3. If it is closing bracket pop and check if it matches with the corresponding closing bracket
	4. If does not match then return false
*/

    public boolean isValid(String str) {

        if(str.charAt(0)=='}'||str.charAt(0)==']'||str.charAt(0)==')') return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i)=='{' || str.charAt(i)=='(' || str.charAt(i)=='[' )
                stack.push(str.charAt(i));
            else if(str.charAt(i)==')' && !stack.empty()) {
                if(stack.pop() !='(') return false;
            }
            else if(str.charAt(i)==']' && !stack.empty()) {
                if(stack.pop()!='[') return false;
            }
            else if (str.charAt(i)=='}' && !stack.empty()) {
                if(stack.pop()!='{') return false;
            }
            else
                return false;
        }

        return stack.isEmpty();
    }

}
