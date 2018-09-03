package Tree.SegmentTree;

/**
 * Created by yyt on 2018/8/31.
 */
public class RangeSumQueryMutable {
    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    private SegmentTreeNode root;

    public RangeSumQueryMutable(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }
    private SegmentTreeNode buildTree(int[] nums,int start,int end){
        if(end < start)
            return null;
        SegmentTreeNode ret = new SegmentTreeNode(start,end);
        if (start == end)
            ret.sum = nums[start];
        else{
            int mid = start + (end - start) /2;
            ret.left = buildTree(nums,start,mid);
            ret.right = buildTree(nums,mid+1,end);
            ret.sum = ret.left.sum + ret.right.sum;
        }
        return ret;
    }
    void update(int i,int val){
        update(root,i,val);
    }
    private void update(SegmentTreeNode p,int pos,int val){
        if (p.start == p.end)
            p.sum = val;
        else {
            int mid = p.start + (p.end - p.start) / 2;
            if (pos <= mid)
                update(p.left, pos, val);
            else
                update(p.right, pos, val);
            p.sum = p.left.sum + p.right.sum;
        }
    }
    public  int sumRange(int i,int j){
        return sumRange(root,i,j);
    }
    private int sumRange(SegmentTreeNode p,int start,int end){
        if (p.end == end && p.start == start)
            return p.sum;
        else{
            int mid = p.start + (p.end-p.start)/2;
            if (end <= mid)
                return sumRange(p.left,start,end);
            else if (start > mid)
                return sumRange(p.right,start,end);
            else
                return sumRange(p.left,start,mid) + sumRange(p.right,mid+1,end);
        }
    }
    public static void  main(String[] argv){

    }
}
