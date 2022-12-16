package Sorting;


import org.junit.Test;

import java.util.Arrays;

public class MaxIceCreamBarsTest {


    @Test
    public void test1(){
        int[] costs={1,3,2,4,1};
        System.out.println(maxIceCream(costs,7));
    }

    @Test
    public void test2(){
        int[] costs={10,6,8,7,7,8};
        System.out.println(maxIceCream(costs,5));
    }

    @Test
    public void test3(){
        int[] costs={1,6,3,1,2,5};
        System.out.println(maxIceCream(costs,20));
    }


    /*
        Pseudocode
        1. Sort the Array
        2. If coins he has greater than costs[i] reduce the coin and increase the iceCreamCount
    */
    public int maxIceCream(int[] costs, int coins) {
        int count=0;
        Arrays.sort(costs);
        for(int cost:costs){
            if(coins>=cost){
                coins-=cost;
                count++;
            }
            else break;
        }
        return count;
    }
}
