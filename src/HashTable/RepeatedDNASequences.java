package HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yyt on 2018/3/1.
 */
//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example:
// "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
//        Write a function to find all the 10-letter-long sequences (substrings) that
// occur more than once in a DNA molecule.
//
//        For example,
//
//        Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
//        Return:
//        ["AAAAACCCCC", "CCCCCAAAAA"].
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> one = new HashSet<>(  );
        Set<Integer> two = new HashSet<>();
        List<String>res = new ArrayList<>(  );
        int[] map = new int[26];
        map['C'-'A'] = 1;
        map['G'-'A'] = 2;
        map['T'-'A'] = 3;
        for(int i = 0;i <= s.length()-10;i++){
            int v = 0;
            for (int j = i; j < i+10 ; j++) {
                v = v << 2;
                v = v | map[s.charAt( j )-'A'];
            }
            if (one.contains( v )){
                if (!two.contains( v )){
                    res.add( s.substring( i,i+10 ) );
                    two.add( v );
                }
            }
            else
                one.add( v );
        }
        return res;
    }

    public static void main(String[] args) {
        RepeatedDNASequences r = new RepeatedDNASequences();

        List<String>res = r.findRepeatedDnaSequences( "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" );
        for (String e:res)
            System.out.println( e );
    }
}
