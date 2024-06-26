import java.util.*;

public class NoOfProvinces {
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

    public static void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, int vis[], int start){
        vis[start]=1;
        dfs.add(start);
        for(int i:adj.get(start)){
            if(vis[i]!=1){
                dfs(adj, dfs, vis, i);
            }
        }
    }

    public static int provinces(ArrayList<ArrayList<Integer>> adj, int vis[], int start, int V){
        int count=0;
        for(int i=1; i<=V; i++){
            if(vis[i]!=1){
                ArrayList<Integer>dfs=new ArrayList<>();
                dfs(adj,dfs,vis,i);
                System.out.println(dfs);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>(10);
        int V = 8;
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<Integer>());
        }
        int vis[]=new int[V+1];
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 7, 8);
        System.out.println(provinces(adj,vis,1,V));
    }    
}    
