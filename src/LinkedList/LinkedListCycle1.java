package LinkedList;

/**
 * Created by yyt on 2018/1/18.
 */
//Given a linked list, determine if it has a cycle in it.
//
//Follow up:
//        Can you solve it without using extra space?
public class LinkedListCycle1 {
    private class ListNode{
        ListNode next = null;
        int val;
        ListNode(int x){
            val = x;
        }
    }
    public LinkedListCycle1() {

    }
    // 很简单的思路，2个指针，runner 跑的比 walker 快一倍，如果最后runner 和 walker 相遇了，则说明有环。
    public boolean hasCycle(ListNode head){
        ListNode walker = head;
        ListNode runner = head;
        if(head==null)
            return false;
        while(runner.next!=null && runner.next.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
