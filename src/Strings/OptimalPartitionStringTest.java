package Strings;

import org.junit.Test;

import java.util.Arrays;

public class OptimalPartitionStringTest {
    //https://leetcode.com/problems/optimal-partition-of-string/description/
    //2405. Optimal Partition of String

    @Test
    public void test1(){
        String s = "abacaba";
        System.out.println(partitionString(s));
    }

    @Test
    public void test2(){
        String s = "sssss";
        System.out.println(partitionString(s));
    }

    @Test
    public void test3(){
        String s = "abcde";
        System.out.println(partitionString(s));
    }

    public int partitionString(String s) {
        int[] arr = new int[26];
        int count=1;
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==1){
                Arrays.fill(arr,0);
                count++;
            }
            else if(arr[s.charAt(i)-'a']==0 && i==s.length()-1 && count==1)return 1;
            else if(arr[s.charAt(i)-'a']==0 && i==s.length()-1 && count>1) return count++;
            arr[s.charAt(i)-'a']++;
        }
        return count;
    }
}
