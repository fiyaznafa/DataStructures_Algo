package arrays;

import org.testng.annotations.Test;

import java.util.Stack;

public class ValidParentheses {

    @Test
    public void test1(){
        String str ="{[()]}";
        System.out.println(checkValidParentheses(str));
    }

    @Test
    public void test2(){
        String str ="()[]{}";
        System.out.println(checkValidParentheses(str));
    }

    @Test
    public void test3(){
        String str ="(}";
        System.out.println(checkValidParentheses(str));
    }

    @Test
    public void test4(){
        String str ="[])";
        System.out.println(checkValidParentheses(str));
    }

    @Test
    public void test5(){
        String str ="()";
        System.out.println(checkValidParentheses(str));
    }

    /*
        Using Stack
        PseudoCode
        1. Iterate through the string and
        2. Add character to stack if it is an open bracket
        3. If character is a closing bracket pop the stack
        4. If the popped character is not matching the open bracket, string is not validated
     */

    private boolean checkValidParentheses(String str) {

        if(str.charAt(0)=='}'||str.charAt(0)==']'||str.charAt(0)==')') return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i)=='{' || str.charAt(i)=='(' || str.charAt(i)=='[' )
                    stack.push(str.charAt(i));
            else if(str.charAt(i)==')' && !stack.empty()) {
                Character pop = stack.pop();
                if(pop!='(') return false;
            }
            else if(str.charAt(i)==']' && !stack.empty()) {
                Character pop = stack.pop();
                if(pop!='[') return false;
            }
            else if (str.charAt(i)=='}' && !stack.empty()) {
                Character pop = stack.pop();
                if(pop!='{') return false;
            }
            else
                return false;
        }


        if(stack.empty())return true;

        return false;
    }
}
