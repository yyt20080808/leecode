package Tree.PathSum;

import Tree.ConstructBinaryTreefromPreorderandInorderTraversal;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyt on 2018/1/30.
 */
//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//        For example:
//        Given the below binary tree and sum = 22,
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \    / \
//        7    2  5   1
//        return
//        [
//        [5,4,11,2],
//        [5,8,4,5]
//        ]
public class PathSum2 {
    private List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<List<Integer>>(  );
        ArrayList<Integer> tempList = new ArrayList<>(  );
        DFS(tempList,sum,root);
        return res;
    }
    private void DFS( ArrayList<Integer> tempList,int sum,TreeNode root){
        if(root==null)
            return;
        if(root.left == null && root.right==null){
            if(root.val==sum){
                // 成功找到一组解
                tempList.add( sum );
                res.add( new ArrayList<>( tempList ) );
                tempList.remove( tempList.size()-1 );
            }
            return;
        }
        tempList.add( root.val );
        DFS( tempList,sum-root.val, root.left);
        DFS( tempList,sum-root.val, root.right);
        tempList.remove( tempList.size()-1 );
    }

    public static void main(String[] args) {
        int[] preorder = {2,0,4,6,3,5,7};
        int[] inorder = {4,6,0,2,5,3,7};
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = c.buildTree( preorder,inorder );
        PathSum2 p = new PathSum2();
        p.pathSum( root,12 );
    }
}
