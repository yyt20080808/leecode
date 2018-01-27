package Array;

/**
 * Created by yyt on 2018/1/26.
 */
public class CountingBits {
    public CountingBits() {

    }
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 0; i <=num ; i++) {
            res[i] = res[i >> 1] + (i&1);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
