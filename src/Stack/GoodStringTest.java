package Stack;

import org.junit.Test;

import java.util.Stack;

public class GoodStringTest {

    //https://leetcode.com/problems/make-the-string-great/description/
//1544. Make The String Great

    @Test
    public void test1(){
        String s="leEeetcode";
        System.out.println(makeGood(s));
    }

    @Test
    public void test2(){
        String s="NAanorRoOrROwnTNW";
        System.out.println(makeGood(s));
    }

/*
	Pseudocode
	1. add to stack
	2. Check if next char Case , peek and check if char is opp case
		i. If char is same and diff case then remove stack
	3. If char is diff add to stack
*/

    private String makeGood(String s){
        if(s.length()==1)return s;
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));

        for(int i=1;i<s.length();i++)	{
            if(!stack.isEmpty()&& checkGoodChar(stack.peek(),s.charAt(i))){
                    stack.pop();
            }
            else
                stack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())sb.append(stack.pop());
        return sb.reverse().toString();
    }

    private boolean checkGoodChar(char a, char b){
        if(Character.isLowerCase(a)){
            return Character.toUpperCase(a)==b;
        }
        else
            return Character.toLowerCase(a)==b;
    }
}
