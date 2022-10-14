package arrays;

import org.testng.annotations.Test;

public class LongestCommonPrefix {

    @Test
    public void testCase1(){
        String[] strs = {"elegance","banana","crane"};
        System.out.println(checkLongestCommonPrefix(strs));
    }



    @Test
    public void testCase2(){
        String[] strs = {"verygood","verybad","ver"};
        System.out.println(checkLongestCommonPrefix(strs));
    }

    @Test
    public void testCase3(){
        String[] strs = {"flower","flower","flower"};
        System.out.println(checkLongestCommonPrefix(strs));
    }

    @Test
    public void testCase4(){
        String[] strs = {"cir","car"};
        System.out.println(checkLongestCommonPrefix(strs));
    }

    private String checkLongestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs.length==0) return  "";
        else if(strs.length==1)return strs[0];
        else{
            String firstString = strs[0];
            for(int i=0;i<firstString.length();i++){
                char c = firstString.charAt(i);
                for(int j=1;j<strs.length;j++){
                    if(i>=strs[j].length()|| c!=strs[j].charAt(i) )
                        return sb.toString();
                    if(j== strs.length-1)sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
