package DFS;

import java.util.*;

/**
 * Created by yyt on 2018/9/12.
 */
public class ReconstructItine {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>(  );
        Map<String,List<String>> map = new HashMap<>(  );
        for (String[] str:tickets){
            if(!map.containsKey( str[0] )){
                List<String> temp = new ArrayList<>(  );
                temp.add( str[1] );
                map.put( str[0],temp );
            }
            else
                map.get( str[0] ).add( str[1] );
        }
        Iterator<Map.Entry<String,List<String>>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,List<String>> entry = it.next();
            Collections.sort( entry.getValue() );
        }
        res.add( "JFK" );
        String now = "JFK";
        while(!map.isEmpty()){
            List<String> s = map.get( now );
            String temp = s.get( 0 );
            res.add( temp );
            s.remove( 0 );
            if (s.isEmpty())
                map.remove( now );
            now = temp;
        }
        return res;

    }

    public static void main(String[] args) {
        String[][] t = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},
                {"ATL","JFK"},{"ATL","SFO"}};
        ReconstructItine r = new ReconstructItine();
        List<String>res = r.findItinerary( t );
    }
}
