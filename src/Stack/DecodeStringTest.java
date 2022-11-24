package Stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeStringTest {


    //3[a2[c]bd2[df]]
    //3[ad2[df3[er]]]

    @Test
    public void test1(){
        String str ="3[a]2[bc]";
        System.out.println(decodeString(str));
    }

    @Test
    public void test2(){
        String str ="3[a2[c]bd2[df]]";
        System.out.println(decodeString(str));
    }

    @Test
    public void test3(){
        String str ="100[leetcode]";
        System.out.println(decodeString(str));
    }


    //https://leetcode.com/problems/decode-string/

/*
	Pseudocode
	1. Iterate each char in the string
	2. If the char is other than ] push into the stack
	3. If the char is ] start pop till the opening bracket is found.
	4. Pop char after the [ and x times to string
*/

    private String decodeString(String s){
        Stack<Character> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count;
        for(char c:s.toCharArray())	{
            if(c!=']')stack.push(c);
            else{
                while(stack.peek()!='[')list.add(stack.pop());
                stack.pop();
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))sb.append(stack.pop());
                count = Integer.parseInt(sb.reverse().toString());
                while(count>0){
                    for(int i=list.size()-1;i>=0;i--)
                        stack.push(list.get(i));
                    count--;
                }
                list.clear();
                sb.setLength(0);
            }
        }

        while(!stack.isEmpty())sb.append(stack.pop());
        //sb.insert(0,stack.pop());
        return  sb.reverse().toString();
    }
}
