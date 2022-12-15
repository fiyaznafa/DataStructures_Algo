package twoPointer;

import org.junit.Test;

public class StockBuySell_II_Test {

    @Test
    public void test1(){
        int[] prices ={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    @Test
    public void test2(){
        int[] prices ={1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

        /*
            Pseudocode
            1. Make the 1st price as buy -> prices[0]
            2. Iterate through the array
            3. Check if next element is greater than the buy value
                i. If greater calculate to profit
                ii. Else make the current item as buy
        */
        public int maxProfit(int[] prices) {
            int maxProfit=0,buy=prices[0];
            for(int i=1;i<prices.length;i++){
                if(prices[i]>buy) maxProfit+=prices[i]-buy;
                buy=prices[i];
            }
            return maxProfit;

    }
}
