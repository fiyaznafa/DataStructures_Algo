package LinkedListImp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IntersectionListTest {

    @Test
    public void test1(){
        LinkedListImplementation list1 = new LinkedListImplementation();
        LinkedListImplementation tempList = new LinkedListImplementation();
        list1.add(4);
        list1.add(1);


        LinkedListImplementation list2 = new LinkedListImplementation();
        list2.add(5);
        list2.add(6);
        list2.add(1);

        tempList.add(8);
        tempList.add(4);
        tempList.add(5);

        list1.add(tempList.head);
        list2.add(tempList.head);

        ListNode interSection = findInterSectionOptimized(list1.head, list2.head);
        while (interSection!=null)
        {
            System.out.println(interSection.value);
            interSection=interSection.next;
        }
    }

    private ListNode findInterSection(ListNode head1, ListNode head2) {
        ListNode temp1=head1;
        List<ListNode> list = new ArrayList<>();
        while(temp1!=null){
            list.add(temp1);
            temp1=temp1.next;
        }
        temp1=head2;
        while(temp1!=null){
            if(list.contains(temp1))return temp1;
            temp1=temp1.next;
        }
        return null;
    }

    /*
        Pseudocode
        1. Find the length of the both list
        2. Find the diff of the list
        3. For the big list, find the starting point to compare
        4. Iterate both the strings and check if they are equal, return the node
     */

    private ListNode findInterSectionOptimized(ListNode headA, ListNode headB) {
        int length1 = findLength(headA) ;
        int length2 = findLength(headB) ;

        int diff = Math.abs(length1-length2);
        if(length1>length2) {
            while (diff > 0) {headA = headA.next;diff--;}
        }
        else {
            while (diff>0){headB=headB.next;diff--;}
        }



        while(headA!=null){
            if(headA==headB)return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }

    private int findLength(ListNode head) {
        ListNode temp = head;
        int count =0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }


}
