package Maps;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RearrangeStringTest {
    @Test
    public void test1(){
        String str1="coder";
        String str2="cdero";
        System.out.println(rearrange(str1,str2));
    }

    @Test
    public void test2(){
        String str1="rkqodlw";
        String str2="world";
        System.out.println(rearrange(str1,str2));
    }

    @Test
    public void test3(){
        String str1="helloWord";
        String str2="h3llo";
        System.out.println(rearrange(str1,str2));
    }

    @Test
    public void test4(){
        String str1="hlloWrd";
        String str2="hollo";
        System.out.println(rearrange(str1,str2));
    }

    private boolean rearrange(String str1, String str2) {
        Map<Character,Integer> map1 = new HashMap<>();
        for(char c:str2.toCharArray()) map1.put(c, map1.getOrDefault(c,0)+1);
        Map<Character,Integer> map2 = new HashMap<>();
        for(char c:str1.toCharArray()){
            if(map1.containsKey(c))map2.put(c, map2.getOrDefault(c,0)+1);
        }
        return map1.equals(map2);
    }

}
