import java.util.*;

public class DFSTraversal {
        public static class Node{
            int data;
            Node left;
            Node right;
            public Node(int data){
                this.data=data;
            }
        }
    
        public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        public static void dfs(ArrayList<ArrayList<Integer>>adj, int vis[], ArrayList<Integer> dfs, int start){
            dfs.add(start);
            vis[start]=1;

            for(int i:adj.get(start)){
                if(vis[i]!=1){
                    dfs(adj, vis, dfs, i);
                }
            }
        }
    
        public static void main(String[] args) {
            ArrayList<ArrayList<Integer>> adj =new ArrayList<>(10);
            int V=9;
            for(int i=0;i<=V;i++){
                adj.add(new ArrayList<Integer>());
            }
            addEdge(adj,1,2);
            addEdge(adj,1,6);
            addEdge(adj,2,3);
            addEdge(adj,2,4);
            addEdge(adj,6,7);
            addEdge(adj,6,9);
            addEdge(adj,4,5);
            addEdge(adj,7,8);
            addEdge(adj,5,8);
            int vis[]=new int[10];
            ArrayList<Integer>dfs=new ArrayList<>();
            dfs(adj, vis, dfs, 1);
            System.out.println(dfs);
        }    
}