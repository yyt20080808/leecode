package LinkedList;

//A linked list is given such that each node contains an additional
// random pointer which could point to any node in the list or null.
//
//        Return a deep copy of the list.
public class CopyListWithRandomPointer {
    private class RandomListNode{
        int label;
        RandomListNode next,random;
        RandomListNode(int x){
            this.label = x;
        }
    }
    public RandomListNode copyRandomList(RandomListNode head){
        // 第一轮循环,将新建的那些节点都依次放到复制节点的身后，random指针先不管
        RandomListNode p = head,newp;
        if(head == null)
            return null;
        while(p!=null){
            newp = new RandomListNode(p.label);
            newp.next = p.next;
            p.next = newp;
            p = newp.next;
        }
        // 第二轮循环，对random指针复制
        p = head;
        RandomListNode rand;
        while(p!=null){
            newp = p.next;
            rand = p.random;
            if(rand!=null)
                newp.random = rand.next;
            p = p.next.next;
        }
        // 第三轮循环了， 将newp 和 p 分离出来，达到实现的目的。
        p = head;
        RandomListNode res=p.next;
        while(p!=null){
            newp = p.next;
            p.next = newp.next;
            if(p.next!=null)
                newp.next = p.next.next;
            p = p.next;
        }
        return res;
    }
}
