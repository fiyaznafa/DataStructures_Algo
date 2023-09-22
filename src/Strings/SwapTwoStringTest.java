package Strings;


import org.junit.Test;

public class SwapTwoStringTest {

    @Test
    public void test1(){
        String str1 ="abc";
        String str2 ="xyz";
        swapStrings(str1,str2);
    }

    private void swapStrings(String str1, String str2) {
        int str1Length=str1.length();
        str1=str1+str2;
        str2=str1.substring(0,str1Length);
        str1=str1.substring(str1Length);
        System.out.println(str1);
        System.out.println(str2);
    }

}
