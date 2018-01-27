package Tree;

/**
 * Created by yyt on 2018/1/25.
 */
//Invert a binary tree.
//        4
//        /   \
//        2     7
//        / \   / \
//        1   3 6   9
//        to
//        4
//        /   \
//        7     2
//        / \   / \
//        9   6 3   1
public class InvertBinaryTree {
    public InvertBinaryTree() {

    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode temp = root.left;
        invertTree( root.left );
        invertTree( root.right );
        root.left = root.right;
        root.right = temp;

        return root;
    }
    public static void main(String[] args) {
        int[] preorder = {2,1,4,6,3,5,7};
        int[] inorder = {4,6,1,2,5,3,7};
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = c.buildTree( preorder,inorder );

        InvertBinaryTree i = new InvertBinaryTree();
        root = i.invertTree( root );
    }
}
