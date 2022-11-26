package LinkedListImp.DoubleLinkedListImp;

public class DoubleLinkedListImp {
    Dll head;
    Dll tail;
    int length;


    public void addAtEnd(int value){
        if(head==null)head=tail=new Dll(value);
        else{
            tail.next=new Dll(value);
            tail.next.prev=tail;
            tail=tail.next;
        }
        length++;
    }

    public void addAtStart(int value){
        if(head==null)head=new Dll(value);
        else {
            Dll temp= new Dll(value);
            temp.next = head;
            head.prev=temp;
            head=temp;
        }
        length++;
    }

    public void addAll(int[] nums){
        for(int num:nums)addAtEnd(num);
    }

    public int get(int index){
        if(head==null || index<0 || index>length-1)throw new IllegalArgumentException("List is empty or index out of Bound");
        int count=0;
        Dll temp = head;
        while(count!=index && temp.next!=null){
            temp=temp.next;
            count++;
        }
        return temp.value;
    }

    public void set(int index,int value){
        if(head==null || index<0 || index>length-1)throw new IllegalArgumentException("List is empty or index out of Bound");
        int count = 0;
        Dll temp = head;
        while (count != index && temp.next != null) {
            temp = temp.next;
            count++;
        }
        temp.value=value;
    }

    public void remove(int index){
        if(head==null || index<0 || index>length-1)throw new IllegalArgumentException("List is empty or index out of Bound");
        int count=0;
        Dll temp = head;
        while(count!=index && temp.next!=null){
            temp=temp.next;
            count++;
        }
        if(temp.next==null){temp.prev.next=null;tail=temp.prev;}
        else if(temp.prev==null){temp.next.prev=null;head=temp.next;}
        else{
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
        }
        length-=1;
    }

    public void removeValue(int value){
        Dll temp = head;
        while(temp.value!=value && temp.next!=null)temp=temp.next;
        if(temp.value==value){
        if(temp.next==null){temp.prev.next=null;tail=temp.prev;}
        else if(temp.prev==null){temp.next.prev=null;head=temp.next;}
        else{
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
        }
        length-=1;}
    }

    public void removeAllValue(int value){
        Dll temp = head;
        while (temp!=null){
            if(temp.value==value){
                if(temp.next==null){temp.prev.next=null;tail=temp.prev;}
                else if(temp.prev==null){temp.next.prev=null;head=temp.next;}
                else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                length-=1;
            }
            temp=temp.next;
        }

    }

    public void display(){
        Dll temp = head;
        while (temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public int size(){return length;}
}
