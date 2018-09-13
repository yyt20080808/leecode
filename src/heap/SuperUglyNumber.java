package heap;

/**
 * Created by yyt on 2018/9/13.
 */
//解题思路：
//        要使得super ugly number不漏掉，那么需要使用每个因子去乘以其对应的“第一个”丑数。那么何为对应的“第一个”丑数？
//
//        首先，利用ugly[]数组来保存所有的超级丑数，ugly[i]表示第i+1个超级丑数；
//
//        接着利用pointer[]数组来表示每个因子对应的“第一个”丑数的下标。pointer数组长度当然需要和primes长度一致，且初始化为0，代表着每个因子对应的“第一个”丑数都是ugly[0]；
//
//        接下来我们以primes[2,7,13,19],pointer[0,0,0,0],ugly[0]=1作为初始条件往下看：
//
//        遍历primes数组，用每个因子都乘以其对应的第一个丑数，即ugly[0]=1,可以发现1x2=2是最小值，故ugly[1]=2;但要注意，此时的pointer数组发生了变化：
//
//        由于当前产生的丑数2是由2这个因子乘以它的对应“第一个”丑数得到的，因此需要将pointer[0]加一。pointer[0]是2这个因子对应的“第一个”丑数的下标，因为当前已经使用了2x1，如果不更新，则下一轮还是会用2这个因子去乘以第一个丑数(ugly[0]).将其更新后，则意味着2这个因子对应的第一个丑数已经改变了，变成了ugly[1].而其他三个对应的“第一个”丑数还是ugly[0]。
//
//        我们接着看下一轮：2x2【即ugly[pointer[1]]x2】,1x7,1x13,1x19，发现还是2这个因子得到的数最小，故更新：ugly[2]=2x2=4,pointer[0]=2；
//
//        下一轮：4x2,1x7,1x13,1x19,可以发现当前这一轮最小值是7，且由因子7产生，故更新：ugly[3]=7,pointer[1]=1；
//
//        以此类推....
//        如果更新过程中，出现最小值不止一个的话，则其对应的pointer的值都需要增加1。
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n,int[]primes){
        int[] ugly = new int[n];
        ugly[0] = 1;
        int []pointer = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int minV = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0;j< primes.length;j++){
                int temp = ugly[pointer[j]] * primes[j];
                if (temp < minV){
                    minV = temp;
                    minIndex = j;
                }
                else if (temp == minV)
                    pointer[j]++;
            }
            ugly[i] = minV;
            pointer[minIndex]++;
        }
        return ugly[n-1];
    }

    public static void main(String[] args) {
        int[] primes = {2,7,13,17};
        SuperUglyNumber s = new SuperUglyNumber();
        s.nthSuperUglyNumber( 12,primes );
    }
}
