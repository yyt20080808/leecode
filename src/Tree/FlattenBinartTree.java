package Tree;

import DFS.ValidateBinarySearchTree;

import java.util.ArrayList;

/**
 * Created by yyt on 2018/1/21.
 */
//Given a binary tree, flatten it to a linked list in-place.
//
//        For example,
//        Given
//
//        1
//        / \
//        2   5
//        / \   \
//        3   4   6
//        The flattened tree should look like:
//        1
//         \
//          2
//           \
//            3
//             \
//              4
//               \
//                5
//                 \
//                  6
public class FlattenBinartTree {


    public FlattenBinartTree() {

    }


    public void flatten(TreeNode root) {

        if (root==null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        flatten( left );
        flatten( right );

        root.right = left;
        TreeNode cur = root;
        while(cur.right!=null)
            cur = cur.right;
        cur.right = right;

    }



    public static void main(String[] args) {
        int[] preorder = {2, 1, 4, 6, 3, 5, 7};
        int[] inorder = {4, 6, 1, 2, 5, 3, 7};
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = c.buildTree( preorder, inorder );
        FlattenBinartTree f = new FlattenBinartTree();
        f.flatten( root );
    }
}
