package Array;

/**
 * Created by yyt on 2018/1/26.
 */
//Given a non negative integer number num. For every numbers i in the range
// 0 ≤ i ≤ num calculate the number of 1's in their binary representation and
// return them as an array.
public class CountingBits {
    public CountingBits() {

    }
    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 0; i <=num ; i++) {
            res[i] = res[i >> 1] + (i&1);
        }
        return res;
    }
    public static void main(String[] args) {
        for(int e : countBits( 10 ))
        System.out.println(e);
    }
}
