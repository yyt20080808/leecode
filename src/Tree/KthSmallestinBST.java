package Tree;

/**
 * Created by yyt on 2018/3/14.
 */
//Given a binary search tree, write a function kthSmallest to find the kth smallest
// element in it.
//
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
//        Follow up:
//        What if the BST is modified (insert/delete operations) often and you need
// to find the kth smallest frequently? How would you optimize the kthSmallest routine?
public class KthSmallestinBST {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode temp = root;
        int s;
        if(root==null)
            return 0;
        s = size( root.left )+1;
        while(s!=k){
            // k 大一些，要往右子树上面靠
            if (s < k){
                k = k-s;
                temp = temp.right;
                s = size( temp.left )+1;
            }
            // s 大一些
            else if(s > k){
                temp = temp.left;
                s = size( temp.left )+1;
            }
        }
        return temp.val;
    }

    private int size(TreeNode p){
        if(p==null)
            return 0;
        return size( p.left )+size( p.right )+1;
    }

    public static void main(String[] args) {
        KthSmallestinBST k = new KthSmallestinBST();
        int[] preorder = {2,1,3};
        int[] inorder = {1,2,3};
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = c.buildTree( preorder,inorder );
        assert k.kthSmallest( root,2 )== 2;
        assert k.kthSmallest( root,1 )== 1;
        assert k.kthSmallest( root,3 )== 3;
    }
}
