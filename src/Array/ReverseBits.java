package Array;

/**
 * Created by yyt on 2018/3/5.
 */
//Reverse bits of a given 32 bits unsigned integer.

//        For example, given input 43261596 (represented in binary as
// 00000010100101000001111010011100), return 964176192
// (represented in binary as 00111001011110000010100101000000).
public class ReverseBits {
    public int reverseBits(int n) {

        int res = 0x0;
        for(int i = 31;i >=0;i--){
            if((1 & n) == 1){
                res = (res | (1 << i));
            }
            n = (n>>1);
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();
        r.reverseBits( 0x80000001 );
    }
}
