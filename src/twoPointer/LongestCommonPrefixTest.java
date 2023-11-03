package twoPointer;

import org.junit.Test;

import java.util.Arrays;

public class LongestCommonPrefixTest {

    @Test
    public void test1(){
        String[] strs =new String[] {"flower","flow","flight"};
        String s = longestCommonPrefixSort(strs);
        System.out.println(s);
    }

    @Test
    public void test2(){
        String[] strs =new String[] {"dog","racecar","car"};
        String s = longestCommonPrefixSort(strs);
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs.length==0) return  ""; // No Elements in array
        else if(strs.length==1)return strs[0]; // One element in array
        else{
            String firstString = strs[0]; // Flower
            for(int i=0;i<firstString.length();i++){  // f l o w e r   4
                char c = firstString.charAt(i);  // f
                for(int j=1;j<strs.length;j++){ // flow , flight     flow   flowe
                    if(i>=strs[j].length()|| c!=strs[j].charAt(i) )
                        return sb.toString();
                    if(j== strs.length-1)sb.append(c);
                }
            }
        }
        return sb.toString();

    }


    public String longestCommonPrefixSort(String[] strs) {
        Arrays.sort(strs); // lexigropahically  alphabetically sort
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int start = 0;
        while(start < s1.length() && start < s2.length()){
            if(s1.charAt(start) == s2.charAt(start)){
                start++;
            } else {
                break;
            }
        }
        return s1.substring(0, start);
    }


}
