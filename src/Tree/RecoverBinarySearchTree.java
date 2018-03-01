package Tree;

/**
 * Created by yyt on 2018/2/28.
 */
public class RecoverBinarySearchTree {
    private TreeNode firstNode,secondNode;
    private TreeNode prevNode;
    public void recoverTree(TreeNode root) {
        prevNode= new TreeNode(Integer.MIN_VALUE);
        travel( root );
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
    private void travel(TreeNode node){
        if(node == null)
            return;
        travel( node.left );
        if(firstNode==null && prevNode.val > node.val){
            firstNode = prevNode;
        }
        if(firstNode!=null && prevNode.val > node.val){
            secondNode = node;
        }
        prevNode = node;
        travel( node.right );

    }

    public static void main(String[] args) {

    }
}
