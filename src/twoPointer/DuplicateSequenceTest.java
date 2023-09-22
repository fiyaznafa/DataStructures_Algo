package twoPointer;


import org.junit.Test;

public class DuplicateSequenceTest {

    @Test
    public void test1(){
        String str="aabbcaa";
        System.out.println(findDuplicateSequence(str));
    }

    @Test
    public void test2(){
        String str="aaabbbccaaad";
        System.out.println(findDuplicateSequence(str));
    }

    @Test
    public void test3(){
        String str="abbc";
        System.out.println(findDuplicateSequence(str));
    }

    @Test
    public void test4(){
        String str="abcd";
        System.out.println(findDuplicateSequence(str));
    }

    private int findDuplicateSequence(String str) {
        int left=0,right=1,count=0;
        while(right<str.length()){
            if(str.charAt(left)==str.charAt(right)){
                count++;
                while(right<str.length() && str.charAt(right)==str.charAt(left))right++;
            }
            left=right;
            right++;
        }
        return count;
    }
}
