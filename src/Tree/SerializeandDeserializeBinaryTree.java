package Tree;



import java.util.*;

/**
 * Created by yyt on 2018/1/27.
 */
//Serialization is the process of converting a data structure or object into
// a sequence of bits so that it can be stored in a file or memory buffer,
// or transmitted across a network connection link to be reconstructed later in the same
// or another computer environment.
//
//        Design an algorithm to serialize and deserialize a binary tree.
// There is no restriction on how your serialization/deserialization algorithm should work.
// You just need to ensure that a binary tree can be serialized to a string and this string
// can be deserialized to the original tree structure.
//
//        For example, you may serialize the following tree
//
//        1
//        / \
//        2   3
//        / \
//        4   5
//        as "[1,2,3,null,null,4,5]",
// just the same as how LeetCode OJ serializes a binary tree.
// You do not necessarily need to follow this format,
// so please be creative and come up with different approaches yourself.
//
//
//
//        Note: Do not use class member/global/static variables to store states.
// Your serialize and deserialize algorithms should be stateless.
public class SerializeandDeserializeBinaryTree {
    // 不是说有先序遍历和 中序遍历重构一棵树的故事吗？
    // 这儿的主要问题在于，不能有重复元素！！！！
    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>(  );
//        preOrder( root,res );
//        inOrder(root,res);
//        return res.toString();
//    }
//    private void preOrder(TreeNode x, ArrayList<Integer>res){
//        if(x==null)
//            return;
//        res.add(x.val);
//        preOrder( x.left,res );
//        preOrder( x.right,res );
//    }
//    private void inOrder(TreeNode x, ArrayList<Integer>res){
//        if(x==null)
//            return;
//        inOrder( x.left,res );
//        res.add(x.val);
//        inOrder( x.right,res );
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        String a = data.substring( 1,data.length()-1 );
//        String[] res = a.split( "," );
//        int length = res.length / 2;
//        int[] preOrders = new int[length];
//        int[] inOrders = new int[length];
//        for (int i = 0; i <length ; i++)
//            preOrders[i] = Integer.valueOf( res[i].trim() );
//        for (int i = length; i < 2*length ; i++)
//            inOrders[i-length] = Integer.valueOf( res[i].trim()  );
//
//        // 开始使用inOrder 和 preOder 来构建了
//        TreeNode root = buildTree( preOrders,0, length-1,inOrders,0,length-1);
//        return root;
//    }
//
//    private TreeNode buildTree(int[] pre, int prestart, int preend,
//                               int[] in, int instart, int inend) {
//        // 现在开始使用递归构造了
//        if(prestart > preend || instart > inend)
//            return null;
//        int rootval = pre[prestart];
//        int inindex;
//        // 找到中序遍历中的index 与 其对应
//        for(inindex=instart;inindex<=inend;inindex++){
//            if(rootval == in[inindex])
//                break;
//        }
//        int len = inindex - instart;
//        // 开始new 这个节点
//        TreeNode root = new TreeNode( rootval );
//        root.left = buildTree( pre,prestart+1,prestart+len,in,instart,instart + len -1 );
//        root.right = buildTree( pre,prestart+len+1,preend,in,inindex+1,inend );
//        return root;
//    }


    private static final String spliter = ",";
    private static final String NN = "X";
    // 还是先序遍历的方法，对路径中间的null点用X表示
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll( Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }


    public static void main(String[] args) {
        int[] preorder = {2, 1, 4, 6, 3, 5, 7};
        int[] inorder = {4, 6, 1, 2, 5, 3, 7};
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = c.buildTree( preorder, inorder );

        SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();
        String a = s.serialize( root );
        TreeNode b = s.deserialize( a );
    }
}
