package Array;

import java.util.*;

//Given a list of non negative integers, arrange them such
// that they form the largest number.
//
//        For example, given [3, 30, 34, 5, 9], the largest formed
// number is 9534330.
//
//        Note: The result may be very large, so you need to return
// a string instead of an integer.
public class LargestNumber {
    public String largestNumber(int[] nums) {
        boolean flag = false;

        List<List<Integer>> x = new ArrayList<List<Integer>>();
        for (int e : nums){
            if(e != 0)
                flag = true;
            x.add(toArray(e));
        }
        if (!flag)
            return "0";

        Collections.sort(x, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o2, List<Integer> o1) {

                int o1Length = o1.size();
                int o2length = o2.size();

                int N = Math.min(o1Length, o2length);
                for (int i = 1; i <= N; i++) {
                    if (o1.get(o1Length - i) > o2.get(o2length - i)) {
                        return 1;
                    } else if (o1.get(o1Length - i) < o2.get(o2length - i))
                        return -1;
                }
                if (o1Length > o2length) {
                    List<Integer> bbb = o1.subList(0, o1Length - N);
                    return compare(o2, bbb);
                } else if (o2length > o1Length) {
                    List<Integer> bbb = o2.subList(0, o2length - N);
                    return compare(bbb, o1);
                } else return 0;
            }

        });
        StringBuilder t = new StringBuilder();
        for (List<Integer> e : x) {
            for (int i = e.size() - 1; i >= 0; i--) {
                t.append(e.get(i));
            }
        }
        return t.toString();
    }

    private List<Integer> toArray(int a) {
        if (a < 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> res = new ArrayList<>();
        if (a == 0) {
            res.add(0);
            return res;
        }
        int b = a;
        while (b != 0) {
            res.add(b % 10);
            b = b / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {999,998,997,9,333,998997};
        LargestNumber l = new LargestNumber();
        System.out.println(l.largestNumber(nums));
    }

}
