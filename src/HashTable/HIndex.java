package HashTable;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yyt on 2018/9/7.
 */
//Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
//
//        According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
//
//        Example:
//
//        Input: citations = [3,0,6,1,5]
//        Output: 3
//        Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
//        received 3, 0, 6, 1, 5 citations respectively.
//        Since the researcher has 3 papers with at least 3 citations each and the remaining
//        two with no more than 3 citations each, her h-index is 3.
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort( citations );
        int N = citations.length;
        int count = 1;
        for (int i = 1; i < N ; i++) {
            if (citations[i-1] != citations[i])
                count++;
        }
        int[] m = new int[count];
        int[] t = new int[count];
        count = 0;
        m[0] = 1;
        for (int i = 1; i <citations.length ; i++) {
            if (citations[i-1] != citations[i]){
                count+=1;
                m[count] = 1;
            }
            else
                m[count]++;
        }
        t[0] = m[0];
        for (int i = 1; i < t.length; i++)
            t[i] = t[i-1]+m[i];
//
//        for ( int i = t.length-1; i >=0 ;i--){
//            if( N-t[i-1] >  )
//        }




        return 1;
    }

    public static void main(String[] args) {
        HIndex h = new HIndex();
        int[]t = {3,0,3,0,3,12};
        h.hIndex( t );
    }
}
