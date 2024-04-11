import java.util.*;
public class LowestCommonAncestor {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static int findLCA(Node n,Node n1,Node n2){
        return lowestCommonAncestor(n,n1,n2).data;
    }

    public static Node lowestCommonAncestor(Node n,Node n1,Node n2){
        if(n==null||n==n1||n==n2){
            return n;
        }
        Node left=lowestCommonAncestor(n.left,n1,n2);
        Node right=lowestCommonAncestor(n.right,n1,n2);
        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else{
            return n;       //ancestor
        }
    }

    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(8);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=g;
        
        System.out.println(findLCA(a,d,g));
    }    
}
