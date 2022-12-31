package QueueImp;

import org.junit.Test;

import java.util.*;

public class ShootingTargetTest {


    public static void main(String[] args) {
        long n=1000000;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=1;i<=n;i++)queue.add(i);

        int  count=0;
        long sum=0;
        while(queue.size()>1){
            if(count%2==0) {
                int x=queue.poll();
                if(x>queue.peek())count=-1;
                sum+=x;
            }
            else {
                int x=queue.poll();
                if(x>queue.peek())count=-1;
                queue.addLast(x);
            }
            count++;
        }
        System.out.println(sum);
    }


/*
    @Test
    public void test1(){
        System.out.println(points(2));
    }

    private int points(int n)
    {
        if(n==1)
            return 0;
        // If only one target left
        if (n == 2)
            return 1;

            // If odd number of targets left
        else if (n % 2 == 1)
            return poi;nts(n - 1) + ((n / 2) + 1);

            // If even number of targets left
        else
            return points(n - 1) + (n / 2);
    }*/



    /*
    n = 7
points(7) = points(6) + (7/2 + 1)               15+4 != 24
points(6) = points(5) + (6/2 + 1)               11+4
points(5) = points(4) + (5/2 + 1)               8+3
points(4) = points(3) + (4/2 + 1)              5+3
points(3) = points(2) + (3/2 + 1)            3+2
points(2) = points(1) + (2/2 + 1)              1+2
points(1) = 1
     */
}
