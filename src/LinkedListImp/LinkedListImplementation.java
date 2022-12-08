package LinkedListImp;


public class LinkedListImplementation {

    public ListNode head;
    public ListNode tail;
    public int length=0;

    public void add(int value){
        if(head==null)head=tail=new ListNode(value);
        else{
            tail.next=new ListNode(value);
            tail=tail.next;
        }
        length++;
    }

    public void add(int[] values){
        for (int value:values) add(value);
    }

    public void add(ListNode node){
        if(head==null)head=tail=node;
        else {
            tail.next=node;
            while(node.next!=null)node=node.next;
            tail=node;
        }
    }

    public ListNode get(int index){
        if(index<0 || head==null || index>length) System.out.println(("List is empty or index is not valid"));
        int count=0;
        ListNode temp=head;
        while (count!=index && temp!=null){
            temp=temp.next;
            count++;
        }
        return temp;
    }

    public void set(int index,int value){
        if(index<0 || head==null || index>=length) System.out.println(("List is empty or index is not valid"));
        int count=0;
        ListNode temp=head;
        while (count!=index && temp!=null){
            temp=temp.next;
            count++;
        }
        temp.value=value;
    }
    public void removeIndex(int index){
        if(index<0 || head==null || index>=length) System.out.println(("List is empty or index is not valid"));
        if(index==0){head=head.next;length--;return;}
        int count=0;
        ListNode temp=head;
        while(count!=index-1){temp=temp.next;count++;}
        if(temp.next.next==null){temp.next=null;tail=temp;}
        else temp.next=temp.next.next;
        length--;
    }

    public void removeValue(int removeValue){
        if(head==null) System.out.println(("List is empty"));
        ListNode temp =head;
        if(head.value==removeValue){head=head.next;length--;return;}
        while(temp.next!=null && temp.next.value!=removeValue)temp=temp.next;
        if(temp.next==null)return;
        if(temp.next.value==removeValue){
            if(temp.next.next==null){temp.next=null;tail=temp; }
            else
            temp.next=temp.next.next;
            length--;
        }
    }

    public void removeAll(int removeValue){
        if(head==null){ System.out.println(("List is empty"));return;}
        ListNode temp =head;
        while(head.value==removeValue){head=head.next;length--;}
        while(temp.next!=null){
            if(temp.next.value==removeValue){
                if(temp.next.next==null){temp.next=null;tail=temp;}
                else temp.next=temp.next.next;
                length--;
            }
            else temp= temp.next;
        }
    }

    public int indexOf(int search){
        ListNode temp = head;
        int index=0;
        if(head==null) {System.out.println("List is empty");return -1;}
        else{
            while(temp.next!=null && temp.value!=search) {
                temp = temp.next;
                index++;
            }
        }
        return temp.value==search?index:-1;
    }

    public int lastIndexOf(int search){
        ListNode temp = head;
        int count=0,index=0;
        if(head==null) {System.out.println("List is empty");return -1;}
        else{
            do {
                if(temp.value==search)index=count;
                count++;
                temp = temp.next;
            }while (temp!=null);
        }
        return index;
    }


    public void displayList(){
        ListNode temp=head;
        while(temp!=null) {
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public int size(){
        return length;
    }

    public static void main(String[] args) {
        LinkedListImplementation list = new LinkedListImplementation();
        list.add(10);
        list.add(15);
        list.add(13);
        list.displayList();
        list.removeIndex(0);
        list.displayList();
        list.removeIndex(1);
        list.displayList();
        list.add(10);
        list.add(15);
        list.add(13);
        list.displayList();
        list.removeValue(10);
        System.out.println("Removing value");
        list.displayList();
        System.out.println(list.size());
        list.add(25);
        list.set(0,0);
        list.displayList();
        list.set(1,12);
        list.displayList();
        list.set(3,3);
        list.displayList();
        System.out.println(list.indexOf(0));
        System.out.println(list.indexOf(12));
        System.out.println(list.indexOf(13));
        System.out.println(list.indexOf(3));
        System.out.println(list.indexOf(4));
        list.add(12);
        list.displayList();
        System.out.println(list.lastIndexOf(0));
        System.out.println(list.lastIndexOf(12));
        list.removeValue(12);
        list.add(1);
        list.add(9);
        list.displayList();
        LinkedListImplementation list1 = new LinkedListImplementation();
        System.out.println("list1");
        list1.add(30);
        list1.add(30);
        list1.add(30);
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(30);
        list1.displayList();
        list1.removeAll(30);
        list1.displayList();
        list1.add(40);
        list1.displayList();
        int[] arr= new int[]{50,60,0,100,0};
        list1.add(arr);
        list1.displayList();
    }
}
