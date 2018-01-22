package Array;

/**
 * Created by yyt on 2018/1/15.
 */
//这道题让我们求下一个排列顺序，有题目中给的例子可以看出来，如果给定数组是降序，则说明是全排列的最后一种情况，则下一个排列就是最初始情况，可以参见之前的博客 Permutations 全排列。我们再来看下面一个例子，有如下的一个数组
//
//        1　　2　　7　　4　　3　　1
//
//        下一个排列为：
//
//        1　　3　　1　　2　　4　　7
//
//        那么是如何得到的呢，我们通过观察原数组可以发现，如果从末尾往前看，数字逐渐变大，到了2时才减小的，
// 然后我们再从后往前找第一个比2大的数字，是3，那么我们交换2和3，再把此时3后面的所有数字转置一下即可，
// 步骤如下：
// {1,2,7,4,3,1}
//        1　　2　　7　　4　　3　　1
//
//        1　　2　　7　　4　　3　　1
//
//        1　　3　　7　　4　　2　　1
//
//        1　　3　　1　　2　　4　　7
public class NextPermutation {
    public NextPermutation() {

    }

    public void nextPermutation(int[] nums) {
        int N = nums.length;
        int first = N, last = N;
        // 从后往前找到最后递增的数字的index
        for (int i = N-2; i >= 0; i--)
            if (nums[i+1] > nums[i]) {
                first = i;
                break;
            }

        //如果是递减序列，返回成为一个递增序列
        if (first == N) {
            reverse( nums, 0 );
            return;
        }
        // 找一个last,同样要从后往前比较奥
        for (int i = N-1; i > first ; i--) {
            if (nums[first]<nums[i]){
                last = i;
                break;
            }
        }
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
        reverse( nums, first + 1 );

    }

    private void reverse(int[] nums, int i) {
        int l = i, r = nums.length - 1;
        int temp;
        while (l < r) {
            temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] p = {1,2,5,4,5};
//        int[] p = {1, 2, 7, 4, 3, 1};
        n.nextPermutation( p );
        for (int e : p)
            System.out.println( e );
    }
}
