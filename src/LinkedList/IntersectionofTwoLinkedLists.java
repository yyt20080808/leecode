package LinkedList;

/**
 * Created by yyt on 2018/1/22.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int N = 0;
        int M = 0;
        ListNode p = headA;
        while (p != null) {
            N++;
            p = p.next;
        }
        p = headB;
        while (p != null) {
            M++;
            p = p.next;
        }
        if (M == 0 || N ==0)
            return null;
        // 如果N 比M 大
        p = headA;
        while (N > M) {
            p = p.next;
            N--;
        }
        headA = p;
        p = headB;
        // 如果M 比N 大
        while (M > N) {
            p = p.next;
            M--;
        }
        headB = p;

        while(headA != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
