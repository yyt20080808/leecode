package Countings;

/**
 * Created by yyt on 2018/1/26.
 */
//Count the number of prime numbers less than a non-negative number, n.

public class CountPrime {
    public CountPrime() {

    }

    // 建立一个大小为n的数组，将所有的非质数找出来就可以了
    public int countPrimes(int n) {
        if (n < 2)
            return 0;
        boolean[] x = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            // 首先i 是prime
            if (!x[i]) {
                int temp = n/i +1;
                for (int j = i; j <= temp && i * j < n; j++)
                    x[i * j] = true;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrime c = new CountPrime();
        System.out.println( c.countPrimes( 10 ) );
    }
}
