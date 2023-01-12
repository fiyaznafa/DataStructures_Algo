package twoPointer;

import org.junit.Test;

public class StockBuySell_IIITest {


    @Test
    public void test1(){
        int[] prices={1,2,3,0,2};
        System.out.println(maxProfitCoolDown(prices));
    }



    /*
        Pseudocode
        1. Take 1st element as buy :- price[0] and initialize currentProfit =0, maxProfit =0
        2. Traverse array
        3. If next element is less than buy and current Profit is zero
            then buy = currElement
        4. If next element is less than buy current Profit is greater than zero
            curr Profit remains and go to next element, make this coolDown period
        5. If next element is greater than buy ,  currElement-buy > currProfit
            currentProfit=currElement - buy
        6. If next element is greater than buy and currElement-buy < currProfit
            Add currProfit to MaxProfit , reset the currentProfit
     */


    private int maxProfitCoolDown(int[] prices) {
        int currentProfit=0,buy=prices[0],maxProfit=0, coolDown=-1;
        for (int currentPrice:prices) {
            if(currentPrice>buy)currentProfit= Math.max(currentProfit,currentPrice-buy);
            else if(currentPrice<buy && coolDown<0)coolDown=currentPrice;
            else if(currentPrice<buy && coolDown>0)buy=currentPrice;
            maxProfit=Math.max(maxProfit,currentProfit);
        }
        return maxProfit;
    }

}
