package Stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class DiscountShopTest {
    //https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
    //1475. Final Prices With a Special Discount in a Shop
    @Test
    public void  test1(){
        int[] prices ={8,4,6,2,3};
        System.out.println(Arrays.toString(finalPriceRefactored(prices)));
        }


    @Test
    public void  test2(){
        int[] prices ={1,2,3,4,5};
        System.out.println(Arrays.toString(finalPriceRefactored(prices)));
    }


@Test
public void  test3(){
        int[] prices ={10,1,1,6};
    System.out.println(Arrays.toString(finalPriceRefactored(prices)));
}

/*
    Pseudocode - Stack
    1. Add first value to stack
    2. If next value is less than or equal to top value at stack then add the diff to output array
        output[stack.peek()] = prices[stack.pop()] - prices[i]
    3. Else add the value to
 */


    private int[] finalPrice(int[] prices) {
        int[] output = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<prices.length;i++){
            if(!stack.isEmpty() && prices[stack.peek()]>=prices[i]){
                while(!stack.isEmpty() && prices[stack.peek()]>=prices[i])
                    output[stack.peek()]=prices[stack.pop()]-prices[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty())output[stack.peek()]=prices[stack.pop()];
        return output;
    }


    private int[] finalPriceRefactored(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<prices.length;i++){
                while(!stack.isEmpty() && prices[stack.peek()]>=prices[i])
                    prices[stack.peek()]=prices[stack.pop()]-prices[i];
            stack.push(i);
        }
        return prices;
    }

}


