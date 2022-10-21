package arrays;

import org.junit.Test;

public class ReverseOnlyLettersTest {
    //https://leetcode.com/problems/reverse-only-letters/ 10:48

    /*
    Example 1:
Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 */
    /*
		Pseudocode
		1. With left pointer at start of the string and right pointer at the end of the string iterate.
		2. If both are Letters swap and move both pointers
		3. If left is letter and right is not move right
		4. If right is letter and left is not move left
		5. Else move both

		//Start 10:48 Code 10:55 End 11:03 Debug:11:06
	*/

    @Test
    public void test1(){
        String s =  "ab-cd";
        System.out.println(reverseOnlyLetters(s));
    }

    private String reverseOnlyLetters(String s){
        int left=0,right=s.length()-1;
        char[] charArray = s.toCharArray();
        char temp;
        if(s.length()==1) return s;
        StringBuilder sb = new StringBuilder();

        while(left<right){
            if(Character.isAlphabetic(charArray[left]) && Character.isAlphabetic(charArray[right])){
                temp=charArray[left];
                charArray[left++]=charArray[right];
                charArray[right--]=temp;
            }
            else if(!Character.isAlphabetic(charArray[left]))left++;
            else if(!Character.isAlphabetic(charArray[right]))right--;
            else {
                left++;right--;
            }
        }
        for (char c:charArray) sb.append(c);

        return sb.toString();
    }


}
