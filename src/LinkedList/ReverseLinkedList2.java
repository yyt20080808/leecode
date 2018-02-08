package LinkedList;
//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//        For example:
//        Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//        return 1->4->3->2->5->NULL.
//
//        Note:
//        Given m, n satisfy the following condition:
//        1 ≤ m ≤ n ≤ length of list.
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(2);
        res.next = head;
        ListNode prev,p,q;
        if(head==null)
            return null;
        prev = res;
        p = head;
        m = m-1;
        n = n-m;
        while(m>0 && p!=null){
            m--;
            prev = p;
            p = p.next;
        }
        // prev is the temp head
        ListNode k = p,temp;
        prev.next = null;
        while(n>0 && p!=null){
            n--;
            temp = p.next;
            p.next = prev.next;
            prev.next = p;
            p = temp;
        }
        if(p!=null){
            while(prev.next != null )
                prev = prev.next;
            prev.next = p;
        }
        return res.next;
    }
}
