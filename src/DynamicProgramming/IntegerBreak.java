package DynamicProgramming;

//Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
//
//        Example 1:
//
//        Input: 2
//        Output: 1
//        Explanation: 2 = 1 + 1, 1 × 1 = 1.
//        Example 2:
//
//        Input: 10
//        Output: 36
//        Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
//        Note: You may assume that n is not less than 2 and not larger than 58.
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dy = new int[n+1];
        dy[1] = 1;
        dy[2] = 1;
        for(int i = 3;i <= n;i++){
            for(int j = 1;j <=i-j;j++){
                int temp = Math.max( dy[j],j );
                int temp2 = Math.max( dy[i-j],i-j );
                dy[i] = Math.max(dy[i],temp*temp2);
            }
        }
        return dy[n];
    }

    public static void main(String[] args) {
        IntegerBreak ib = new IntegerBreak();
        System.out.println(ib.integerBreak( 10 ));
    }
}
