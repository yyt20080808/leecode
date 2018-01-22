package Tree;

import DFS.ValidateBinarySearchTree;

/**
 * Created by yyt on 2018/1/20.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public ConstructBinaryTreefromPreorderandInorderTraversal() {

    }
    // 很明显要用递归来解决这个问题了。
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         int N = preorder.length;
        TreeNode root = buildTree( preorder,0, N-1,inorder,0,N-1);
        return root;
    }
    private TreeNode buildTree(int[] pre,int prestart,int preend, int[] in,int instart,int inend){
         if(prestart > preend || instart > inend)
             return null;
         int inindex;
         int rootval = pre[prestart];
         // 找到中序遍历中的index 与 其对应
         for(inindex=instart;inindex<=inend;inindex++){
             if(rootval == in[inindex])
                 break;
        }
        int len = inindex - instart;
        // 开始new 这个节点
        TreeNode root = new TreeNode( rootval );
        // 精髓所在
        root.left = buildTree( pre,prestart+1,prestart+len,in,instart,instart+len-1 );
        root.right = buildTree( pre,prestart+len+1,preend,in,instart+len+1,inend );
        return root;

    }

    public static void main(String[] args) {
        int[] preorder = {2,1,4,6,3,5,7};
        int[] inorder = {4,6,1,2,5,3,7};
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        c.buildTree( preorder,inorder );
    }
}
