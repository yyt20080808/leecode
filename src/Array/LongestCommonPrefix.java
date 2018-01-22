package Array;

/**
 * Created by yyt on 2018/1/14.
 *  这道题目我真的觉得没有任何意思的哈
 *  easy
 */
public class LongestCommonPrefix {
    public LongestCommonPrefix() {

    }
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";
        int N = strs.length;
        int min_index = 0;
        int temp = strs[0].length();
        int x;
        for(int i = 1;i<N;i++){
            x = strs[i].length();
            if(x < temp){
                min_index = i;
                temp = x;
            }
        }

        for(int i = 0;i < N;i++){
            for(int j = 0;j < temp;j++){
                if(strs[min_index].charAt(j) != strs[i].charAt(j)){
                    temp = j;
                    break;}

            }
        }
        return strs[0].substring(0,temp);
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] a = {"a","abc","asd"};
        System.out.print(  l.longestCommonPrefix( a ));
    }
}
