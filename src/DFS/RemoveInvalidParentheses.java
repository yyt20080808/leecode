package DFS;

import java.util.*;

//Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
//
//Note: The input string may contain letters other than the parentheses ( and ).
//
//Examples:
//"()())()" -> ["()()()", "(())()"]
//"(a)())()" -> ["(a)()()", "(a())()"]
//")(" -> [""]
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int N = s.length();
        List<String> list = new ArrayList<String>();
//        if(N==0){
//            list.add("");
//            return list;
//        }
        Set<String> res = new HashSet<>();
        for(int i = 0;i<=N;i++){
            StringBuilder tempString = new StringBuilder();
            DFS(s,0,i,res,tempString,0);
            if(!res.isEmpty())
                break;
        }

        list.addAll(res);
        return list;
    }
    public  void DFS(String s,int index, int left, Set<String> res,StringBuilder tempString,int stat){
        if(left < 0)
            return;
        else if(left == 0){
            //如果后面都不用删除了, 终结条件
            // 检验stat 值
            int tempindex = index;
            while(stat >=0 && tempindex <s.length()){
                if(s.charAt(tempindex)=='(')
                    stat++;
                else if(s.charAt(tempindex)==')')
                    stat--;
                tempindex++;
            }
            if (stat == 0) {
                StringBuilder x = new StringBuilder(tempString);
                if(index < s.length())
                    x.append(s.substring(index, s.length()));
                res.add(x.toString());
            }
            return;
        }
        //
        for (int i = index; i < s.length(); i++) {
            char x = s.charAt(i);
            if(x!= '(' && x!= ')'){
                tempString.append(x);
                continue;
            }
            String temp = tempString.toString();
            // 先尝试删去index表示的字符
            DFS(s,i+1,left-1,res,tempString,stat);
            tempString = new StringBuilder(temp);
            if(x == '('){
                stat++;
                tempString.append(x);
            }else{
                stat--;
                // 减枝条件
                if(stat<0){
                    // back
                    return;
                }
                tempString.append(x);
            }
        }
    }
    public static void main(String[] args) {
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        String temp = "";
        r.removeInvalidParentheses(temp);
    }
}
