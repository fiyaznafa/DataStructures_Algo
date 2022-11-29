package twoPointer;

import org.junit.Test;

public class CountRepeatedCharTest {

    @Test
    public void test1(){
        String str="abcd";
        countSubSequence(str);
    }

    @Test
    public void test2(){
        String str="aabbccd";
        countSubSequence(str);
    }

    private void countSubSequence(String str) {
        int left=0,right=1,count=0;
        while (right<str.length()){
            if(str.charAt(left)==str.charAt(right)){
                while(str.charAt(left)==str.charAt(right) && right<str.length()-1)right++;
                count++;
                left=right;
            }
            else left++;
            right++;
        }
        System.out.println(count);
    }


}
