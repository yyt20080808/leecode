package LinkedList;

import java.util.List;
import java.util.Stack;

/**
 * Created by yyt on 2018/3/2.
 */
//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//        reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//        You must do this in-place without altering the nodes' values.
//
//        For example,
//        Given {1,2,3,4}, reorder it to {1,4,2,3}.
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        ListNode p1, p2;
        p1 = head;
        p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // 从p1 开始的地方 ,后面反转
        ListNode phead = p1;

        ListNode start = p1.next,q;
        phead.next = null;
        while (start!= null) {
            q = start.next;
            start.next = phead.next;
            phead.next = start;
            start = q;
        }
        start = p1.next;
        phead = head;
        p1.next = null;
        while(start != null){
            ListNode temp = start.next;
            start.next = phead.next;
            phead.next = start;
            start = temp;
            phead = phead.next.next;
        }

    }
    public ListNode buildList(int[] nums) {
        ListNode root = new ListNode( -1 );
        ListNode x = root;
        for (int e : nums) {
            x.next = new ListNode( e );
            x = x.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ReorderList s = new ReorderList();
        int[] nums = {1,2,3,4};
        ListNode x = s.buildList( nums );
        s.reorderList( x );
        while (x != null) {
            System.out.println( x.val );
            x = x.next;
        }
    }
}
