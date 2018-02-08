package Array;

/**
 * Created by yyt on 2018/1/29.
 */
public class PlusOne {
    public PlusOne() {

    }

    public static int[] plusOne(int[] digits) {
        int N = digits.length;
        int i = 0;
        while (i < N && digits[i] == 9)
            i++;
        if(i==N){
            int[] x = new int[N+1];
            x[0] = 1;
            return x;
        }
        int j = N-1;
        while(j > i && digits[j] == 9){
            digits[j]=0;
            j--;
        }
        digits[j]+=1;
        return digits;
    }

    public static void main(String[] args) {
        int[]nums = {9,9,1,9};
        for(int e:plusOne(nums))
            System.out.println(e);
    }
}
