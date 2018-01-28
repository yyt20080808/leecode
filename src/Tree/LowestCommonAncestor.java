package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by yyt on 2018/1/26.
 */

//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//
//        According to the definition of LCA on Wikipedia:
// “The lowest common ancestor is defined between two nodes v and w as the lowest node
// in T that has both v and w as descendants
// (where we allow a node to be a descendant of itself).”
//
//        _______3______
//        /              \
//        ___5__          ___1__
//        /      \        /      \
//        6      _2       0       8
//        /  \
//        7   4
//        For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
// Another example is LCA of nodes 5 and 4 is 5,
// since a node can be a descendant of itself according to the LCA definition.
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        if(right == null) return left;
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 用2个队列来记录找到 p和q的路线，然后找到两个队列的前缀
        Deque<Boolean> x1 = new LinkedList<>(  );
        Deque<Boolean> x2 = new LinkedList<>(  );
        DFS( x1,root,p );
        DFS( x2,root,q );
        TreeNode res = root;
        boolean a,b;
        while(x1.size() > 0 && x2.size()>0){
            a = x1.pollFirst();
            b = x2.pollFirst();
            if(a==b){
                if(a)
                    res = res.right;
                else
                    res = res.left;
            }
            else
                return res;
        }
        return res;
    }

    private Boolean DFS(Deque<Boolean> x,TreeNode root, TreeNode target){
        if(root == null)
            return false;
        if(root == target)
            return true;
        // 向左子树搜索一下
        x.addLast( false );
        boolean judge = DFS(x,root.left,target);
        if(judge)
            return true;
        x.pollLast();
        x.addLast( true );
        judge = DFS( x,root.right,target );
        if (judge)
            return true;
        x.pollLast();
        return false;
    }


    public static void main(String[] args) {
        int[] preorder = {2,1,4,6,3,5,7};
        int[] inorder = {4,6,1,2,5,3,7};
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = c.buildTree( preorder,inorder );
        TreeNode p = root.right.right;
        TreeNode q = root.right.left;
        TreeNode res = new LowestCommonAncestor().lowestCommonAncestor( root,p,q );
        System.out.print( res.val );
    }
}
