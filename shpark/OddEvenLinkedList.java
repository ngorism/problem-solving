
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null ||head.next==null)return head;

        ListNode even=head,evenTail=even;
        ListNode odd=head.next,oddTail=odd;

        ListNode tmp = head.next;
        while (tmp!=null && tmp.next!=null){
            evenTail.next=tmp.next;
            oddTail.next=tmp.next.next;
            evenTail=evenTail.next;
            oddTail=oddTail.next;
            tmp=oddTail;
        }
        evenTail.next=odd;
        return even;
    }
}
