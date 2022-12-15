package twoPointer;

import org.junit.Test;

public class StockBuySellTest {

    @Test
    public void test1(){
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }


    @Test
    public void test2(){
        int[] prices={7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int buy = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy)
                profit = Math.max(profit, prices[i] - buy);
            else buy = prices[i];
        }
        return profit;
    }
}
