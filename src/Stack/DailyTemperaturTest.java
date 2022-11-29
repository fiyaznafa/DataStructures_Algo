package Stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperaturTest {

    @Test
    public void test1(){
        int[] temperature ={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperature)));
    }


    @Test
    public void test2(){
        int[] temperature ={73};
        System.out.println(Arrays.toString(dailyTemperatures(temperature)));
    }

    private int[] dailyTemperatures(int[] temperature) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperature.length ; i++) {
                while (!stack.isEmpty() && (temperature[stack.peek()] < temperature[i]) )
                    temperature[stack.peek()] = i - stack.pop();
             stack.push(i);
        }
        while(!stack.isEmpty())temperature[stack.pop()]=0;
        return temperature;
    }


    /*
        Pseudocode - Stack
        1. Add first value to stack
        2. Check if next value is grater than stack value
            i. If greater than put the diff of indices in output array
            ii. Else add the value to stack
     */




}
