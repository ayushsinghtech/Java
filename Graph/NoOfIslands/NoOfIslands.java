import java.util.*;

public class NoOfIslands {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public static void dfs(int matrix[][], int vis[][], int row, int col){
        int r[]={-1,-1,-1,0,0,1,1,1};
        int c[]={-1,0,1,-1,1,-1,0,1};

        for(int i=0;i<r.length;i++){
            if(r[i]+row>=0 && r[i]+row<matrix.length && c[i]+col>=0 && c[i]+col<matrix[0].length 
            && matrix[row+r[i]][col+c[i]]==1 && vis[row+r[i]][col+c[i]]!=1){
                vis[r[i]+row][c[i]+col]=1;
                dfs(matrix, vis, row+r[i], col+c[i]);
            }
         }
    }

    public static int noOfIslands(int matrix[][], int vis[][]){
        int count=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1 && vis[i][j]==0){
                    dfs(matrix, vis, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int matrix[][]={{0,1,1,0},{0,1,1,0},{0,0,1,0},{0,0,0,0},{1,1,0,1}};
        int vis[][]=new int[matrix.length][matrix[0].length];

        System.out.println(noOfIslands(matrix, vis));
    }    
}
