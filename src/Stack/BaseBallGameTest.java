package Stack;

import org.junit.Test;

import java.util.Stack;

public class BaseBallGameTest {

    //https://leetcode.com/problems/baseball-game/description/


    @Test
    public void test1(){
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(ops));
    }

    @Test
    public void test2(){
        String[] ops = {"5","2","C","D","+"};
        System.out.println(calPoints(ops));
    }

    @Test
    public void test3(){
        String[] ops = {"1","C"};
        System.out.println(calPoints(ops));
    }




/*
	Pseudocode - Stack
	1. If char is '+'
		i.    Pop the char store in temp var
		ii.  peek the stack and calculate sum = poped Element + peek
		iii. Push popped element and Push sum
	2. If char is 'D'
		i. Calculcate double - peek the stack and push the double value of peeked element
	3. If char is 'C'
		pop the element
	4. Else Push the element
	5. Calculcate sum - by popping each element and adding to sum
*/


    private int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum=0;
        for(String c:operations){
            int temp=0;
            int element=0;
            if(c=="+"){
                temp=stack.pop();
                element=stack.peek()+temp;
                stack.push(temp);
                stack.push(element);
            }
            else if(c=="D"){
                temp=stack.peek();
                stack.push(2*temp);
            }
            else if(c=="C")stack.pop();
            else stack.push(Integer.parseInt(c));
            StringBuilder sb = new StringBuilder();
        }

        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }

}
