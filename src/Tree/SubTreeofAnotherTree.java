package Tree;

/**
 * Created by yyt on 2018/2/2.
 */
public class SubTreeofAnotherTree {

   public boolean isSubtree(TreeNode s,TreeNode t){
       if(s==null)
           return false;
       // 先序遍历 哈哈
       return compare( s,t ) || isSubtree( s.left,t )|| isSubtree( s.right,t );
   }
   // 详细比较2棵树是不是一样的
   private boolean compare(TreeNode s,TreeNode t){
       if(s==null && t==null)
           return true;
       else if(s!=null&& t!=null && s.val == t.val)
           return compare( s.left,t.left ) && compare( s.right,t.right );
       return false;
   }

    public static void main(String[] args) {
        int[] preorder = {2,1,4,6,3,5,7};
        int[] inorder = {4,6,1,2,5,3,7};
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = c.buildTree( preorder,inorder );

        int[] preorder2 = {3,5,7};
        int[] inorder2 = {5,3,7};
        ConstructBinaryTreefromPreorderandInorderTraversal c2 = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root2 = c2.buildTree( preorder2,inorder2 );

        SubTreeofAnotherTree s = new SubTreeofAnotherTree();
        System.out.println(s.isSubtree( root,root2 ));
   }
}
