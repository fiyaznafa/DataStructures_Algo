package LinkedListImp;

import org.junit.Test;

public class ReverseLinkedListTest {

    @Test
    public void test1() {
        LinkedListImplementation list = new LinkedListImplementation();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


        ListNode output = reverse(list.head);
        while (output!=null){
            System.out.println(output.value);
            output=output.next;
        }

    }

    private ListNode reverseList(ListNode head) {
        ListNode rev= new ListNode(head.value);

        while(head.next!=null){
            ListNode temp = new ListNode(head.next.value);
            temp.next=rev;
            rev=temp;
            head=head.next;
        }

        return rev;
    }

    /*
        Pseudocode
        1. Take the first node
        2. Store the second node in temp node
        3. Point the second node's next to first node by using a temp var
        4. Iterate till you reach end of the list
     */
    private ListNode reverse(ListNode head){
        ListNode rev=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=rev;
            rev=head;
            head=temp;
        }
        return head;
    }

}
