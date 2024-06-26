import java.util.*;

public class AdjacencyList {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public static void adjList(int V, int E){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // adj.get(i).add(j);  //for edge i->j  directed
        // adj.get(j).add(i);  //for edge i-j undirected  
    }

    public static void main(String[] args) {
        adjList(3,4);
    }    
}

