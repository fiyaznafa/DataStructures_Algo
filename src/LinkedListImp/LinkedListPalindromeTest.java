package LinkedListImp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class LinkedListPalindromeTest {

    @Test
    public void test1(){
        LinkedListImplementation list = new LinkedListImplementation();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);

        Assert.assertTrue(isPalindrome(list.head));
    }

    @Test
    public void test2(){
        LinkedListImplementation list = new LinkedListImplementation();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);

        Assert.assertTrue(isPalindrome(list.head));
    }

    @Test
    public void test3(){
        LinkedListImplementation list = new LinkedListImplementation();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(1);

        Assert.assertFalse(isPalindrome(list.head));
    }

    @Test
    public void test4(){
        LinkedListImplementation list = new LinkedListImplementation();
        list.add(1);
        list.add(1);

        Assert.assertTrue(isPalindrome(list.head));
    }

    private boolean isPalindrome(ListNode head) {
        ListNode temp=head;
        ListNode rev = reverseList(temp);
        while(head!=null){
            if(head.value!= rev.value)return false;
            head=head.next;
            rev=rev.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head){
        ListNode rev= new ListNode(head.value);

        while(head.next!=null){
            ListNode temp = new ListNode(head.next.value);
            temp.next=rev;
            rev=temp;
            head=head.next;
        }

        return rev;
    }

}
