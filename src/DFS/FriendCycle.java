package DFS;

/**
 * Created by yyt on 2018/2/1.
 */
//There are N students in a class. Some of them are friends,
// while some are not. Their friendship is transitive in nature.
// For example, if A is a direct friend of B, and B is a direct friend of C,
// then A is an indirect friend of C. And we defined a friend circle is a group
// of students who are direct or indirect friends.
//
//        Given a N*N matrix M representing the friend relationship
// between students in the class. If M[i][j] = 1,
// then the ith and jth students are direct friends with each other, otherwise not. A
// nd you have to output the total number of friend circles among all the students.
//
//        Example 1:
//        Input:
//        [[1,1,0],
//        [1,1,0],
//        [0,0,1]]
//        Output: 2
//        Explanation:The 0th and 1st students are direct friends,
// so they are in a friend circle.
//        The 2nd student himself is in a friend circle. So return 2.
//        Example 2:
//        Input:
//        [[1,1,0],
//        [1,1,1],
//        [0,1,1]]
//        Output: 1
//        Explanation:The 0th and 1st students are direct friends,
// the 1st and 2nd students are direct friends,
//        so the 0th and 2nd students are indirect friends.
// All of them are in the same friend circle, so return 1.
public class FriendCycle {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        boolean[] isVisited = new boolean[N];
        int solo = 0;
        // 然后再进行 DFS 做uf
        for(int i = 0;i<N;i++){
            // 没访问过i
            if(!isVisited[i]){
                DFS(M,isVisited,i);
                solo++;
            }
        }
        return solo;

    }
    private void DFS(int[][]M ,boolean[] isVisited,int source){
        isVisited[source]=true;
        for (int i = 0; i <M.length ; i++) {
            // 是朋友
            if(M[source][i]==1 &&  !isVisited[i])
                DFS( M,isVisited,i );
        }
    }

    public static void main(String[] args) {

    }
}
