package arrays;


import org.junit.Test;

public class LengthLastWord {

    @Test
    public void test1(){
        String str ="Hello World";
        System.out.println(lenghtofLastWord(str));
    }

    @Test
    public void test2(){
        String str ="   fly me   to   the moon  ";
        String st= str.trim();
        System.out.println(lenghtofLastWord(st));
    }

    @Test
    public void test3(){
        String str ="a";
        String st= str.trim();
        System.out.println(lenghtofLastWordOptimize(st));
    }

    private int lenghtofLastWord(String st) {
            String str= st.trim();
            String[] s = str.split(" ");
            return s[s.length-1].length();
    }

    private int lenghtofLastWordOptimize(String st) {
        int length=0;
        for (int i = st.length()-1; i >=0 ; i--) {
            if(st.charAt(i)!=' ')
                length++;
            else{
                if (length>0)return length;
            }
        }
        return length;
    }
}
