package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyt on 2018/1/29.
 */
//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//        For example:
//        Given "25525511135",
//
//        return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
public class RemoteIpaddress {
    public RemoteIpaddress() {

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int N = s.length();
        if(N < 4){
            return res;
        }
        int[] positions = new int[3];
        DFS( s, res, 0, positions );

        return res;
    }

    private void DFS(String s, List<String> res, int index, int[] positions) {
        if (positions[2] > 0) {
            // 防止int越界 和 防止 出现01.01.01.01的情况 0.10.10.101
            if(s.substring( positions[2] ).length() > 3 || (s.charAt( positions[2] )=='0'&&s.substring( positions[2] ).length() > 1 ))
                return;
            int x = Integer.valueOf( s.substring( positions[2] ) );
            if (x <= 255) {
                // 获得一组结果
                StringBuilder r = new StringBuilder();
                r.append( s.substring( 0, positions[0] ) );
                r.append( '.' );
                r.append( s.substring( positions[0], positions[1] ) );
                r.append( '.' );
                r.append( s.substring( positions[1], positions[2] ) );
                r.append( '.' );
                r.append( s.substring( positions[2] ) );
                res.add( r.toString() );
            }
            return;
        }
        if (index == s.length() - 1)
            return;
        // now用来指导现在是哪个个了
        int now = 0;
        while (positions[now] != 0)
            now++;
        for (int i = index + 1; i <= index + 3 && i < s.length(); i++) {
            if(i > index+1 && s.charAt( index )=='0')
                continue;
            int val = Integer.valueOf( s.substring( index, i ) );

            if (val < 256) {
                positions[now] = i;
                DFS( s, res, i, positions );
                positions[now] = 0;
            }
        }
    }

    public static void main(String[] args) {
        RemoteIpaddress r = new RemoteIpaddress();
       List<String > res =  r.restoreIpAddresses( "010010" );
        for(String e:res)
            System.out.println(e);
    }
}
