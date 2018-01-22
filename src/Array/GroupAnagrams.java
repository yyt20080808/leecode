package Array;


import java.util.*;

/**
 * Created by yyt on 2018/1/16.
 */
public class GroupAnagrams {
    public GroupAnagrams() {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length == 0){
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String e : strs) {
            char[] a = e.toCharArray();
            Arrays.sort( a );
            String temp = String.valueOf(a);
            if(map.containsKey( temp ))
                map.get( temp ).add( e );
            else{
                ArrayList<String> t = new ArrayList<>(  );
                map.put( temp,t);
                t.add( e );
            }
        }
        for(String key: map.keySet()) {
            Collections.sort(map.get(key));
        }
        List<List<String>> res = new ArrayList<List<String>>(map.values());
        return res;
    }

//    private String convert(String s) {
//
//    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] values = {"eat", "tea", "tan", "ate", "nat", "bat"};
        g.groupAnagrams( values );
    }
}
