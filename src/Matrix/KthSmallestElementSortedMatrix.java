package Matrix;

/**
 * Created by yyt on 2018/3/14.
 */
//Given a n x n matrix where each of the rows and columns are sorted
// in ascending order, find the kth smallest element in the matrix.

//Note that it is the kth smallest element in the sorted order,
// not the kth distinct element.
//
//        Example:
//
//        matrix = [
//        [ 1,  5,  9],
//        [10, 11, 13],
//        [12, 13, 15]
//        ],
//        k = 8,
//
//        return 13.
public class KthSmallestElementSortedMatrix {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int count = getLessEqual(matrix, mid);
                if (count < k) lo = mid + 1;
                else hi = mid - 1;
            }
            return lo;
        }

        private int getLessEqual(int[][] matrix, int val) {
            int res = 0;
            // 相当于从左下边开始向斜对角移动
            int n = matrix.length, i = n - 1, j = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] > val) i--;
                else {
                    res += i + 1;
                    j++;
                }
            }
            return res;
        }


    public static void main(String[] args) {
        int[][] nums = {{1,2,10},{2,4,11},{5,16,18}};
        KthSmallestElementSortedMatrix k = new KthSmallestElementSortedMatrix();
        System.out.println(k.kthSmallest( nums,7 ));
    }
}
