package Tree;
//Given an array where elements are sorted in ascending order,
// convert it to a height balanced BST.
//
//        For this problem, a height-balanced binary tree is defined as a
// binary tree in which the depth of the two subtrees of every node never differ
// by more than 1.
//
//
//        Example:
//
//        Given the sorted array: [-10,-3,0,5,9],
//
//        One possible answer is: [0,-3,9,-10,null,5], which represents
// the following height balanced BST:
//
//        0
//        / \
//        -3   9
//        /   /
//        -10  5
public class ConvertSortedToBST {
    public TreeNode sortedArrayToBST (int[]nums){
        int N = nums.length;
        return trace(nums,0,N-1);
    }
    private TreeNode trace(int[] nums,int low,int high){
        if(low > high)
            return null;
        int mid = (low+high) / 2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = trace(nums,low,mid-1);
        res.right = trace(nums,mid+1,high);
        return res;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8};
        ConvertSortedToBST c =new ConvertSortedToBST();
        TreeNode root = c.sortedArrayToBST(nums);
    }
}
