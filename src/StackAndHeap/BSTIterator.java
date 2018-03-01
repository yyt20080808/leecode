package StackAndHeap;

import Tree.TreeNode;

import java.util.Stack;
import java.util.concurrent.ExecutorService;

/**
 * Created by yyt on 2018/2/27.
 */
//
//Implement an iterator over a binary search tree (BST). Your iterator will be
// initialized with the root node of a BST.
//
//        Calling next() will return the next smallest number in the BST.
//
//        Note: next() and hasNext() should run in average O(1)
//        time and uses O(h) memory, where h is the height of the tree.
public class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode cur;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs( root );
        if(!stack.isEmpty())
            cur = stack.pop();
        else
            cur = null;
    }
    private void dfs(TreeNode p){
        TreeNode temp = p;
        while(temp != null){
            stack.push( temp );
            temp = temp.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur!=null;
    }

    /** @return the next smallest number */
    public int next() {
        int res = cur.val;

        dfs( cur.right );
        if(!stack.isEmpty())
            cur = stack.pop();
        else
            cur = null;
        return res;
    }

    public static void main(String[] args) {
        ExecutorService a;
    }
}
