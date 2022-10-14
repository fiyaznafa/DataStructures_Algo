package arrays;

import org.testng.annotations.Test;

public class MergeTwoSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @Test
    public void test1(){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(4);

        ListNode listNode = mergeSortedList(head1, head2);

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    private ListNode mergeSortedList(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(0);
        ListNode mergedList = list;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                mergedList.next=list1;
                list1=list1.next;
            }

            else{
                mergedList.next=list2;
                list2=list2.next;
            }
            mergedList=mergedList.next;
        }

        if(list1!=null) mergedList.next=list1;
        if(list2!=null) mergedList.next=list2;

        return list.next;
    }
}


