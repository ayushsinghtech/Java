package Representation;
import java.util.*;
public class WeightedAdjList {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public static class Pair{
        int node;
        int weight;
        public Pair(int node, int weight){
            this.node=node;
            this.weight=weight;
        }
    }

    public static void adjList(int V, int E){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        // adj.get(i).add(new Pair(j,k));  //for edge i->j  directed with edge weight k
        // adj.get(j).add(new Pair(i,k));  //for edge i-j undirected with edge weight k  
    }

    public static void main(String[] args) {
        adjList(3,4);
    }    
}


    
}
