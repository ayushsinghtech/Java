import java.util.*;

public class TotalNodesInACompleteBT {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    
    public static int totalNodesInCompleteBT(Node n){
        if(n==null){
            return 0;
        }
        int l=leftHeight(n);
        int r=rightHeight(n);
        if(l==r){
            return (1<<l)-1;
        }
        else{
            return totalNodesInCompleteBT(n.left)+totalNodesInCompleteBT(n.right)+1;
        }
    }

    public static int leftHeight(Node n){
        if(n==null){
            return 0;
        }
        return 1+leftHeight(n.left);
    }

    public static int rightHeight(Node n){
        if(n==null){
            return 0;
        }
        return 1+rightHeight(n.right);
    }
    
    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        Node h=new Node(8);
        Node i=new Node(9);
        Node j=new Node(10);
        Node k=new Node(11);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=g;
        d.left=h;
        d.right=i;
        e.left=j;
        e.right=k;

        System.out.println(totalNodesInCompleteBT(a));
    }
}
