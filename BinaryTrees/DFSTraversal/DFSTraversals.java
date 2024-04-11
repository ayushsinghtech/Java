import java.util.*;
public class DFSTraversals{
    
    public static class Node{
        Node left;
        Node right;
        int data;
        public Node(int data){
            this.data=data;
        }
    }

    public static void preorder(Node n){
        if(n==null){
            return;
        }
        System.out.print(n.data+" ");
        preorder(n.left);
        preorder(n.right);
    }
  
    public static void inorder(Node n){
        if(n==null){
            return;
        }
        inorder(n.left);
        System.out.print(n.data+" ");
        inorder(n.right);
    }
    
    public static void postorder(Node n){
        if(n==null){
            return;
        }
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.data+" ");
    }
    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;

        preorder(a);
        System.out.println();
        inorder(a);
        System.out.println();

        postorder(a);
    }
}