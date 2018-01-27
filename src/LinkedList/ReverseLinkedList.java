package LinkedList;

/**
 * Created by yyt on 2018/1/23.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // 自己画个图就很清楚了
        if (head == null || head.next == null)
            return head;
        ListNode p, q, q_next;
        p = head;
        q = head.next;
        p.next= null;
        // 原本下一个值
        while (q != null) {
            q_next = q.next;
            // 交换p,q
            q.next = p;
            p = q;
            q = q_next;
        }
        return p;
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
        ReverseLinkedList s = new ReverseLinkedList();
        int[] nums = {3, 2, 1};
        ListNode root = s.buildList( nums );
        ListNode x = s.reverseList( root );
        while (x != null) {
            System.out.println( x.val );
            x = x.next;
        }
    }
}
