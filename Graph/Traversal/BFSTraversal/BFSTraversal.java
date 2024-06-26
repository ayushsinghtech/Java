import java.util.*;

public class BFSTraversal {
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

        public static ArrayList<Integer> BFS(ArrayList<ArrayList<Integer>> adj, int vis[], int start){
            Queue<Integer>q=new LinkedList<>();
            ArrayList<Integer>bfs=new ArrayList<>();
            q.add(start);
            vis[start]=1;
            while(!q.isEmpty()){
                int front=q.remove();
                bfs.add(front);
                for(int i:adj.get(front)){
                    if(vis[i]!=1){
                        vis[i]=1;
                        q.add(i);
                    }
                }
            }
            return bfs;
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
            ArrayList<Integer>res=new ArrayList<>();
            res=BFS(adj, vis, 1);
            System.out.println(res);
        }    
    }
