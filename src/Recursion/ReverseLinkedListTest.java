package Recursion;

import LinkedListImp.LinkedListImplementation;
import LinkedListImp.ListNode;
import org.junit.Test;

public class ReverseLinkedListTest {

    @Test
    public void test1(){
        LinkedListImplementation list1 = new LinkedListImplementation();
        list1.add(1);
        list1.add(5);
        list1.add(6);
        ListNode reversedList =reverse(list1.head);
        while(reversedList!=null){
            System.out.print(reversedList.value+" ");
            reversedList=reversedList.next;
        }
        System.out.println();
    }


    @Test
    public void test2(){
        LinkedListImplementation list1 = new LinkedListImplementation();
        list1.add(1);
        list1.add(2);
        ListNode reversedList =reverse(list1.head);
        while(reversedList!=null){
            System.out.print(reversedList.value+" ");
            reversedList=reversedList.next;
        }
        System.out.println();
    }

    @Test
    public void test3(){
        LinkedListImplementation list1 = new LinkedListImplementation();
        list1.add(3);
        ListNode reversedList =reverse(list1.head);
        while(reversedList!=null){
            System.out.print(reversedList.value+" ");
            reversedList=reversedList.next;
        }
        System.out.println();
    }

    @Test
    public void test4(){
        LinkedListImplementation list1 = new LinkedListImplementation();
        ListNode reversedList =reverse(list1.head);
        while(reversedList!=null){
            System.out.print(reversedList.value+" ");
            reversedList=reversedList.next;
        }
        System.out.println();
    }

    private ListNode reverse(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode temp = reverse(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
    }
}
