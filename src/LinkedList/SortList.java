package LinkedList;

import Tree.TreeNode;

import java.util.List;

/**
 * Created by yyt on 2018/1/22.
 */
//Sort a linked list in O(n log n) time using constant space complexity.
// 很明显要使用mergeSort
public class SortList {

    public SortList() {

    }
    public ListNode buildList(int[] nums){
        ListNode root = new ListNode( -1 );
        ListNode x = root;
        for(int e:nums){
            x.next = new ListNode( e );
            x = x.next;
        }
        return root.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode walker = head,runner = head;
        ListNode prev = null;
        while(runner != null && runner.next!=null){
            // prev 是用来做merge的起点的。
            prev = walker;
            walker = walker.next;
            runner = runner.next.next;
        }
        prev.next = null;

        ListNode L1 = sortList(head );
        ListNode L2 = sortList( walker );
        return merge( L1,L2 );
    }
    private ListNode merge(ListNode A,ListNode B){
        if(A==null)
            return B;
        else if(B==null)
            return A;
        ListNode res= new ListNode( 1 );
        ListNode x = res;
        while(A != null && B!= null){
            if(A.val <= B.val){
                x.next = A;
                A = A.next;
            }else{
                x.next = B;
                B = B.next;
            }
            x = x.next;
        }
        if(A!= null)
            x.next = A;
        else
            x.next = B;
        return res.next;
    }


    public static void main(String[] args) {
        SortList s = new SortList();
        int[] nums = {3,2,1};
        ListNode root = s.buildList( nums );
        ListNode x = s.sortList(root );
        while(x!=null){
            System.out.println(x.val);
            x = x.next;
        }
    }


}
