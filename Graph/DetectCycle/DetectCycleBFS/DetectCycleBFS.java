import java.util.*;

public class DetectCycleBFS {
    
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public static class Tuple{
        int node;
        int parent;
        public Tuple(int node, int parent){
            this.node=node;
            this.parent=parent;
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>>adj, int a, int b){
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    public static boolean bfs(ArrayList<ArrayList<Integer>>adj, int vis[], int start){
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(start,-1));
        vis[start]=1;

        while(!q.isEmpty()){
            Tuple top = q.remove();
            int node=top.node;
            int parent=top.parent;

            for(int i: adj.get(node)){
                if(vis[i]!=1){
                    vis[i]=1;
                    q.add(new Tuple(i, node));
                }
                else if (i!=parent){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleBFS(ArrayList<ArrayList<Integer>>adj, int vis[], int V){
        for(int i=1;i<=V;i++){
            if(vis[i]!=1){
                if (bfs(adj,vis,i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V=7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj,1,2);
        addEdge(adj,2,5);
        addEdge(adj,5,7);
        addEdge(adj,1,3);
        addEdge(adj,3,6);
        addEdge(adj,6,7);
        addEdge(adj,3,4);

        int vis[]=new int[V+1];
        System.out.println(detectCycleBFS(adj, vis, V));
    }
}
       
    
       
