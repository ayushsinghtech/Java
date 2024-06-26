import java.util.*;

public class AdjacencyMatrix {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public static void adjMatrix(int vertices, int edges){
        int matrix[][]=new int[vertices][vertices];
        Scanner sc=new Scanner(System.in);

        for(int i=0; i<vertices; i++){
            for(int j=0; j<vertices; j++){
                System.out.println("Enter edge weight"+"("+i+","+j+")");
                matrix[i][j]=sc.nextInt();// for directed
                matrix[j][i]=matrix[i][j]; //for undirected
            }
        }
    }

    public static void main(String[] args) {
        adjMatrix(3,4);
    }    
}
