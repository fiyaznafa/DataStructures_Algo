package arrays;

import org.junit.Test;

public class LongPressedNameTest {

    /*
        name = "alex" typed ="aleex"
        name = "saeed" typed ="ssaaedd"
     */

    /*
        Pseduocode
        1. Two pointer ,left pointing to name and right pointing to typed
        2. If left !=right return false
        3. If left ! = left +1 (keep moving right until the right does not match left
        4. else move left and move right
     */

    @Test
    public void test1(){
        String name ="alex";
        String typed="aleex";
        System.out.println(isLongPressed(name,typed));
    }

    @Test
    public void test2(){
        String name ="saeed";
        String typed="saaaedd";
        System.out.println(isLongPressed(name,typed));
    }

    @Test
    public void test3(){
        String name ="abbbab";
        String typed="ab";
        System.out.println(isLongPressed(name,typed));
    }

    private boolean isLongPressed(String name, String typed) {
        int left =0,right=0;
        while(left<name.length()&&right<typed.length()){
            if(name.charAt(left)!=typed.charAt(right))return false;
            if(left<name.length()-1){
                if(name.charAt(left)!=name.charAt(left+1)){
                    while(name.charAt(left)==typed.charAt(right) &&(right<typed.length()-1))right++;
                }
                else right++;
                left++;
            }
            else {
                if(name.charAt(left)!=typed.charAt(right))return false;
                else right++;
            }
        }
        if(right==typed.length()&& left==name.length()-1)
            return true;
        else return false;
    }

}
