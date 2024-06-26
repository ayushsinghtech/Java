import java.util.*;

public class FloodColor {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public static void dfs(int matrix[][], int newMatrix[][], int vis[][], int row, int col, int initColor, int newColor){
        int r[]={-1,0,0,1};
        int c[]={0,-1,1,0};

        for(int i=0;i<r.length;i++){
            if(r[i]+row>=0 && r[i]+row<matrix.length && c[i]+col>=0 && c[i]+col<matrix[0].length 
            && matrix[row+r[i]][col+c[i]]==initColor && vis[row+r[i]][col+c[i]]!=1){
                vis[r[i]+row][c[i]+col]=1;
                newMatrix[r[i]+row][c[i]+col]=newColor;
                dfs(matrix, newMatrix, vis, row+r[i], col+c[i], initColor, newColor);
            }
         }
    }

    public static void floodColor(int matrix[][], int newMatrix[][], int vis[][],int sr, int sc, int newColor){
        int initColor=matrix[sr][sc];
        dfs(matrix, newMatrix, vis, sr, sc, initColor, newColor);
    }

    public static void main(String[] args) {
        int matrix[][]={{1,1,1},{1,1,0},{1,0,1}};
        int vis[][]=new int[matrix.length][matrix[0].length];
        
        int newMatrix[][]=new int[matrix.length][matrix[0].length];
        newMatrix=matrix;
        
        floodColor(matrix, newMatrix, vis, 1, 1, 2);
        for(int i=0;i<newMatrix.length;i++){
            for(int j=0;j<newMatrix[0].length; j++){
                System.out.print(newMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }    
}
   
