package Matrix;

/**
 * Created by yyt on 2018/2/8.
 */
// Given a m x n matrix, if an element is 0, set
// its entire row and column to 0. Do it in place.

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        boolean[] row = new boolean[M];
        boolean[] col = new boolean[N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < M; i++)
            if (row[i]) {
                for (int j = 0; j < N; j++)
                    matrix[i][j] = 0;
            }

        for (int j = 0; j < N; j++) {
            if (col[j]) {
                for (int i = 0; i < M; i++) {
                    matrix[i][j] = 0;
                }
            }
        }


    }

    public static void main(String[] args) {

    }
}
