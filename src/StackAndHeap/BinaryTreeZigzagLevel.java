package StackAndHeap;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yyt on 2018/2/7.
 */
//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its zigzag level order traversal as:
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]
public class BinaryTreeZigzagLevel {
    // BFS 将队列改成 栈， 并且要用两个栈结构来存储这种情况。
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Stack<TreeNode> a = new Stack<TreeNode>();
        Stack<TreeNode> b = new Stack<TreeNode>();
        boolean isleft = true;
        List<Integer> tempList = new ArrayList<>();
        if(root != null)
            a.push(root);
        while(a.size() > 0){
            TreeNode temp = a.pop();
            if(temp != null)
                tempList.add(temp.val);
            BFS(isleft,b,temp);
            if(a.size() == 0){
                Stack<TreeNode> tempStack = a;
                a = b;
                b = tempStack;
                isleft = !isleft;
                res.add(new ArrayList<Integer>(tempList));
                tempList.clear();
            }
        }
        return res;

    }
    private void BFS(boolean isleft,Stack<TreeNode> b, TreeNode root){
        if(isleft){
            if(root.left!=null)
                b.push(root.left);
            if(root.right!=null)
                b.push(root.right);
        }
        else{
            if(root.right!=null)
                b.push(root.right);
            if(root.left!=null)
                b.push(root.left);
        }
    }

    public static void main(String[] args) {

    }
}
