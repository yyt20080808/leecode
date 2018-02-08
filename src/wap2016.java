

import java.util.*;
/**
 * Created by yyt on 2017/5/23.
 */
public class wap2016 {
    public static void main(String[] args){
        int a[] = {1,2,3,0,0,6,7,0,0,0,0,12,13,0,15};
        wap2016.generateTreefromArray b = new wap2016().new generateTreefromArray(a);
        wap2016.TreeNode root =  b.generateTreebycengci();
//        b.BFS();
//        b.nonRecPreOrder( root );
         b.nonRecPostOrder(root);
    }
    class  TreeNode{
        private int key=0;
        private int data=0;
        private boolean isVisted=false;
         private TreeNode leftChild=null;
         private TreeNode rightChild=null;
         public TreeNode getLeftChild() {
             return leftChild;
         }

         public void setLeftChild(TreeNode leftChild) {
             this.leftChild = leftChild;
         }
         public TreeNode getRightChild() {
             return rightChild;
         }

         public void setRightChild(TreeNode rightChild) {
             this.rightChild = rightChild;
         }
        /**
         * @param key  层序编码
         * @param data 数据域
         */
          TreeNode(int key,int data){
            this.key=key;
            this.data=data;
            this.leftChild=null;
            this.rightChild=null;
        }
    }
    public class generateTreefromArray{
        private int[] a;
        private TreeNode root = null;
        private int num = 0;
        private generateTreefromArray(int[] a ){
            this.a = a;

        }
        TreeNode generateTreebycengci(){
            this.root = new TreeNode(1,a[0]);
            int length = a.length;
            // 相当于又添加了一个 outer 对象？
//            wap2016.TreeNode root = new wap2016().new TreeNode(1,b[0])
            this.insertNode(root,2,length);
            this.insertNode(root,3,length);
            return root;
        }

        private  void insertNode(TreeNode root,int start,int length){
            if (start <= length){
                if(a[start-1]!=0){
                    num+=1;
                    TreeNode node = new TreeNode( start, a[start-1] );
                    if (start %2 ==0){
                        root.setLeftChild(node);
                    }
                    else{
                        root.setRightChild(node);
                    }
                    insertNode( node,start*2,length );
                    insertNode( node,start*2+1,length );
                }
            }
        }

        // 层次遍历
        public void BFS(){
            Queue<TreeNode> temp =new LinkedList<TreeNode>();
            temp.add( root );
            TreeNode node;

            while(temp.size()!=0) {
                node = temp.poll();

                System.out.print( node.key );
                System.out.print( '\t' );
                System.out.println( node.data );
                if (node.getLeftChild() != null) {
                    temp.add( node.getLeftChild() );
                }
                if (node.getRightChild() != null) {
                    temp.add( node.getRightChild() );
                }
            }


        }

        // 递归 中序遍历
        public void pre_recursive(TreeNode root){
            if(root.getLeftChild() != null){
                TreeNode node = root.getLeftChild();
                pre_recursive(node);
            }
            System.out.println(root.data);
            if(root.getRightChild() != null){
                TreeNode node = root.getRightChild();
                pre_recursive(node);
            }
        }
        //递归 先序遍历
        public void mid_recursive(TreeNode root){
            System.out.println(root.data);
            if(root.getLeftChild() != null) {
                TreeNode node = root.getLeftChild();
                pre_recursive( node );
            }
            if(root.getRightChild() != null){
                TreeNode node = root.getRightChild();
                pre_recursive(node);
            }
        }

        // 非递归 先序遍历
        public void nonRecPreOrder(TreeNode root){
            Stack<TreeNode> stack =new Stack<TreeNode>();
            TreeNode node = root;
            while(node != null || stack.size()>0){
                while(node != null){
                    stack.add( node );
                    node = node.getLeftChild();
                }
                if(stack.size()>0){
                    node = stack.pop();
                    System.out.println(node.data);
                    node = node.getRightChild();
                }
            }
        }

        //非递归 中序遍历
        public void nonRecInOrder(TreeNode root){
            Stack<TreeNode> stack =new Stack<TreeNode>();
            TreeNode node = root;
            while(node != null || stack.size()>0){
                while(node != null){
                    stack.add( node );
                    System.out.println(node.data);
                    node = node.getLeftChild();
                }
                if(stack.size()>0){
                    node = stack.pop();
                    node = node.getRightChild();
                }
            }
        }
        // 非递归 后序遍历
        public void nonRecPostOrder(TreeNode root){
            Stack<TreeNode> stack =new Stack<TreeNode>();
            Stack<TreeNode> output = new Stack<TreeNode>();
            TreeNode node = root;
            TreeNode temp  = null;
            while(node != null || stack.size() > 0){
                if(node != null){
                    stack.push(node);
                    output.push(node);
                    node = node.getRightChild();
                }
                else{
                    node = stack.pop();
                    node = node.getLeftChild();
                }
                // 这里使用peek
            }
            while(output.size() > 0){
                System.out.println( output.pop().data );
            }

        }
        public void destroy(TreeNode subTree){
            //删除根为subTree的子树
            if(subTree!=null){
                //删除左子树
                destroy(subTree.leftChild);
                //删除右子树
                destroy(subTree.rightChild);
                //删除根结点
                subTree=null;
            }
        }
        private int height(TreeNode subTree){
            if(subTree==null)
                return 0;//递归结束：空树高度为0
            else{
                int i=height(subTree.leftChild);
                int j=height(subTree.rightChild);
                return (i<j)?(j+1):(i+1);
            }
        }


    }



}
