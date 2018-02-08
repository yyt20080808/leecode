package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yyt on 2018/2/1.
 */
//Given a Binary Search Tree (BST), convert it to a Greater Tree such
// that every key of the original BST is changed to the original key plus sum
// of all keys greater than the original key in BST.
//
//        Example:
//
//        Input: The root of a Binary Search Tree like this:
//        5
//        /   \
//        2     13
//
//        Output: The root of a Greater Tree like this:
//        18
//        /   \
//        20     13
public class ConvertBSTtoGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }

    public static void main(String[] args) {
        int[] preorder = {2,1,4,6,3,5,7};
        int[] inorder = {4,6,1,2,5,3,7};
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = c.buildTree( preorder,inorder );

        ConvertBSTtoGreaterTree rrr = new ConvertBSTtoGreaterTree();
        root = rrr.convertBST( root );
        System.out.print( " " );
    }
}
