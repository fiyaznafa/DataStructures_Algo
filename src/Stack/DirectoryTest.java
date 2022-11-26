package Stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class DirectoryTest {
    //https://leetcode.com/problems/crawler-log-folder/description/
//1598. Crawler Log Folder

    @Test
    public void test1(){
        String[] logs={"d1/","d2/","../","d21/","./"};
        Assert.assertEquals(2,minOperations(logs));
    }

    @Test
    public void test2(){
        String[] logs={"d1/","d2/","./","d3/","../","d31/"};
        Assert.assertEquals(3,minOperationsNoStack(logs));
    }

    @Test
    public void test3(){
        String[] logs={"d1/","../","../","../"};
        Assert.assertEquals(0,minOperationsNoStack(logs));
    }


/*
	Pseudocode - Stack
	1. If new dir then add to stack
	2. If ../ - pop the stack (if stack is not empty)
	3. If ./ - do not perform any actions
	4. Return the size of stack
*/

    private int minOperations(String[] logs){
        Stack<String> stack = new Stack<>();
        for(String eachLog :logs){
            if(eachLog.equals("../")){if(!stack.isEmpty())stack.pop();}
            else if(eachLog.equals("./"));
            else stack.push(eachLog);
        }
        return stack.size();
    }


    private int minOperationsNoStack(String[] logs){
        int result=0;
        for(String eachLog :logs){
            if(eachLog.equals("../")){if(result>0)result--;}
            else if(eachLog.equals("./"));
            else result++;
        }
        return result;
    }
}
