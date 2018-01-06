import java.util.Map;

/**
 * Created by yyt on 2017/7/13.
 */
public class xiaohongshu {
    public static void main(String[] args){
        System.out.print(solutions());
    }
    public static int[] solutions(){
        int A[] = {5,3,-2,-1,5,6};
        int B[] = {0,0,0,0,0,0};
        B[5] = A[5];
        for(int i = 4;i>=0;i--){
            B[i] = -1 * B[i+1] +A[i];
        }
        for(int i=0;i<6;i++) {
            System.out.println( B[i] );
        }
        return B;
    }
}
