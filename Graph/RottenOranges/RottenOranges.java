import java.util.*;

public class RottenOranges {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public static class Pair{
        int r;
        int c;
        int t;
        public Pair(int r, int c, int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }

    public static int rottenOranges(int matrix[][]){
        Queue<Pair> q= new LinkedList<>();
        int vis[][]=new int[matrix.length][matrix[0].length];

        int newMatrix[][]=new int[matrix.length][matrix[0].length];
        newMatrix=matrix;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==2){
                    q.add(new Pair(i,j,0));
                    newMatrix[i][j]=2;
                    vis[i][j]=1;
                }
            }
        }
        
        int max=0;

        while(!q.isEmpty()){
            Pair top=q.remove();
            int r=top.r;
            int c=top.c;
            int t=top.t;

            // System.out.println("\n"+r+" "+c+" "+t);
            int row[]={-1,0,0,1};
            int col[]={0,-1,1,0};

            for(int i=0;i<row.length;i++){
                if(r+row[i]>=0 && r+row[i]<matrix.length && c+col[i]>=0 && c+col[i]<matrix[0].length && vis[r+row[i]][c+col[i]]!=1 && matrix[r+row[i]][c+col[i]]==1){
                    newMatrix[r+row[i]][c+col[i]]=2;
                    q.add(new Pair(r+row[i], c+col[i], top.t+1));
                    vis[r+row[i]][c+col[i]]=1;
                    max=Math.max(max,top.t+1);
                    // System.out.println(max);
                }
            }

        }
        
        for(int i=0;i<newMatrix.length;i++){
            for(int j=0;j<newMatrix[0].length;j++){
                System.out.print(newMatrix[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=0;i<newMatrix.length;i++){
            for(int j=0;j < newMatrix[0].length; j++){
                if(newMatrix[i][j]==1){
                    // System.out.println(i +" " +j);
                    return -1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int matrix[][]={{0,1,2},{0,1,1},{0,1,1}};
        System.out.println(rottenOranges(matrix));
    }    
}
   

