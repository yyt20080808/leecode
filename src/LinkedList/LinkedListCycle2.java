package LinkedList;

/**
 * Created by yyt on 2018/1/18.
 */
//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//        Note: Do not modify the linked list.
//
//        Follow up:
//        Can you solve it without using extra space?
public class LinkedListCycle2 {
    private class ListNode{
        ListNode next = null;
        int val;
        ListNode(int x){
            val = x;
        }
    }

    public LinkedListCycle2() {

    }
    public ListNode detectCycle(ListNode head){
        ListNode walker = head;
        ListNode runner = head;
        if(head==null)
            return null;
        boolean isCycle = false;
        while(runner.next!=null && runner.next.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner){
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
            return null;
        walker = head;
        // 相当于让walker 回到起点，然后让walker 和 runner 的速度一样，同时出发，再次相遇就是起始点
        while(walker!=runner){
            walker = walker.next;
            runner = runner.next;
        }
        return walker;
    }

    public static void main(String[] args) {

    }
}
