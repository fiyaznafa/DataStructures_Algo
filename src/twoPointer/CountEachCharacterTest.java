package twoPointer;

import org.junit.Test;

public class CountEachCharacterTest {

    @Test
    public void test1(){
        String s = "zaaabbccaad";
        String exp = "a3b2c2a2d1";
        String output=(codeString(s));
        System.out.println(output);
    }

    @Test
    public void test2(){
        String s = "zaaabbccaaddddd";
        String exp = "a3b2c2a2d1";
        String output=(codeString(s));
        System.out.println(output);
    }

    private String codeString(String s) {
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (right < chars.length) {
            if (chars[left] == chars[right])
                right++;
            else {
                sb.append(chars[left]);
                sb.append(right - left);
                left=right;
            }
        }
        sb.append(chars[right-1]);
        sb.append(right-left);
        return  sb.toString();
    }
}
