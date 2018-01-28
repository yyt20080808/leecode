package Matrix;

/**
 * Created by yyt on 2018/1/26.
 */
//Write an efficient algorithm that searches for a value in an m x n matrix.
// This matrix has the following properties:
//
//        Integers in each row are sorted in ascending from left to right.
//        Integers in each column are sorted in ascending from top to bottom.
//        For example,
//
//        Consider the following matrix:
//
//        [
//        [1,   4,  7, 11, 15],
//        [2,   5,  8, 12, 19],
//        [3,   6,  9, 16, 22],
//        [10, 13, 14, 17, 24],
//        [18, 21, 23, 26, 30]
//        ]
//        Given target = 5, return true.

//        Given target = 20, return false.
public class Search2DMatrix {
    // 这完全可以做一个搜索算法 O(N+M) 从左下角或者右上角开始
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        // 从左下角开始吧
        int row = M-1,col=0;
        while(row >=0 && col < N){
            if(matrix[row][col] == target)
                return true;
            while( matrix[row][col] < target){
                col++;
                if (col == N)
                    return false;
            }

            while(matrix[row][col] > target){
                row--;
                if(row < 0)
                    return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
