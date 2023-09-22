package Strings;

import org.junit.Test;

public class ChessBoardColorTest {

    @Test
    public void test1(){
        String s1 = "a9";
        System.out.println(squareIsWhite(s1));
    }

    public boolean squareIsWhite(String coordinates) {

        coordinates.split("\\s+");
        int firstValue =coordinates.charAt(0)-'a';
        int secondValue = coordinates.charAt(1)-'0';
        System.out.println(secondValue);

        if(firstValue%2==0 && secondValue%2==0)return true;
        else if(firstValue%2==1 && secondValue%2==1)return true;
        else return false;
    }
}
