package LinkedList;

/**
 * Created by yyt on 2018/9/6.
 */
public class InsertionSort {
    public ListNode insertionSortList(ListNode head) {
        ListNode phead = head;
        if (phead==null || phead.next ==null)
            return head;
        head = new ListNode( 0 );
        head.next = phead;
        ListNode pnext = phead.next;
        while(phead.next != null){
            if(pnext.val < phead.val){
                phead.next = phead.next.next;
                // 开始重头开始
                ListNode tempHead = head.next;
                ListNode filHead = head;
                while (tempHead.val < pnext.val){
                    tempHead = tempHead.next;
                    filHead = filHead.next;
                }
                // 找到了插入地点
                filHead.next = pnext;
                pnext.next = tempHead;
                pnext = phead.next;
            }else{
                phead = phead.next;
                pnext = phead.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode( 4 );
        ListNode b = new ListNode( 2 );
        ListNode c = new ListNode( 1 );
        ListNode d = new ListNode( 3 );
        a.next = b;
        b.next = c;
        c.next = d;
        InsertionSort s = new InsertionSort();
        s.insertionSortList( a );
    }
}
