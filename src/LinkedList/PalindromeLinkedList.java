package LinkedList;

/**
 * Created by yyt on 2018/1/25.
 */
//Given a singly linked list, determine if it is a palindrome.


public class PalindromeLinkedList {
    public PalindromeLinkedList() {

    }

    public boolean isPalindrome(ListNode head) {
        ListNode walker = head, runner = head;
        if (head == null || head.next==null)
            return true;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        // 然后将前半部分反转。
        ListNode pre = head, q = head.next, q_next;

        pre.next = null;
        while (q != walker) {
            q_next = q.next;
            q.next = pre;
            pre = q;
            q = q_next;
        }
        // 说明是偶数
        if (runner == null) {
            while (pre != null) {
                if (pre.val != walker.val)
                    return false;
                pre = pre.next;
                walker = walker.next;
            }
            return true;
        }//说明是奇数
        else {
            walker = walker.next;
            while (pre != null) {
                if (pre.val != walker.val)
                    return false;
                pre = pre.next;
                walker = walker.next;
            }
            return true;
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
        PalindromeLinkedList p = new PalindromeLinkedList();
        int[] a = {1,1};
        ListNode root = p.buildList( a );
        System.out.println( p.isPalindrome( root ) );

         a = new int[]{1, 2, 3,3, 2, 1};
        root = p.buildList( a );
        System.out.println( p.isPalindrome( root ) );
    }
}
