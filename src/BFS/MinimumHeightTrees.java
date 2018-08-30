package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
//
//        Format
//        The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
//
//        You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>(  );
        if(n==0)return leaves;
        if(n==1){
            leaves.add( 0 );
            return leaves;
        }
//        List<Set<Integer>> A = new ArrayList<>(  );
//        for(int i = 0;i < n;i++)
//            A.add( new HashSet<Integer>(  ) );
        List<Integer>[] A = new ArrayList[n];
        for (int i = 0; i < n; i++) A[i] = new ArrayList<>();

        for (int[] edge:edges){
            A[ edge[0] ].add( edge[1] );
            A[ edge[1] ].add( edge[0] );
        }
        // 初始化所有叶子节点
        for (int i = 0;i < n;i++)
            if(A[ i ].size() ==1)
                leaves.add( i );
        while(n > 2){
            n = n-leaves.size();
            List<Integer> newLeaves = new ArrayList<>(  );
            for(int i: leaves) {
                for (int toRemove: A[i]){

                    A[toRemove].remove(Integer.valueOf( i ));
                    if (A[toRemove].size() == 1)
                        newLeaves.add( toRemove );
                }
            }
            leaves = newLeaves;
        }
        return leaves;

    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
        MinimumHeightTrees m = new MinimumHeightTrees();
        m.findMinHeightTrees( n,edges );
    }
}
