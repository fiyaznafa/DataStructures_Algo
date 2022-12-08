package Search;

import org.testng.annotations.Test;

public class SqaureRootTest {

    @Test
    public void test1(){
        int n=8;
        System.out.println(squareRoot(n));
    }

    @Test
    public void test2(){
        int n=5;
        System.out.println(squareRoot(n));
    }

    @Test
    public void test3(){
        int n=4456411;
        System.out.println(squareRoot(n));
        System.out.println(Math.sqrt(n));
    }

    private int squareRoot(int x) {
        if(x==1 || x==0)return x;
        long start=1,end=x/2,mid=0;
        long square=0;
        while(start<=end){
            mid=(start+end)/2;
            square =mid*mid;
            if(square==x)return(int) mid;
            else if(square>x)end=mid-1;
            else start=mid+1;
        }
        return (int) start-1;
    }
}
