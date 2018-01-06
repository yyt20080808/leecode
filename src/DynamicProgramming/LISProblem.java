package DynamicProgramming;

/**
 * Created by yyt on 2018/1/5.
 */
public class LISProblem {
    public static int solutions(int[] v) {
        // f【k】可以看作以v【k-1】为序列的最后一个元素的最大元素。
        int[] f = new int[v.length];
        // 全部赋值为0
        for (int i = 0; i < v.length; i++)
            f[i] = 1;

        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j < i; j++) {
                if (v[i] > v[j]) {
                    f[i] = Math.max( f[j] + 1, f[i] );
                }
            }
        }
        int max = 0;
        // 找到最大的那个结果作为返回值
        for (int i = 0; i < v.length; i++) {
            System.out.print(f[i]+" ");
            if (f[i] > max)
                max = f[i];
        }
        return max;

    }

    public static void main(String[] args) {
        int[] v = {9,10,12,4,1,13,2,3,4,5,12,6,7};
        System.out.println( solutions( v ) );
    }
}
