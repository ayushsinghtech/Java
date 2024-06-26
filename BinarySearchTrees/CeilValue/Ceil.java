import java.util.*;
public class Ceil {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static int ceil(Node n,Node key){
        int ceil=-1;
        Node root = n;
        if (n==null){
            return ceil;
        }
        while(n!=null){
            if(n.data==key.data){
                ceil=n.data;
                return ceil;
            }
            else{
                n=n.data<key.data? n.right:n.left;
                if(n!=null){
                    ceil=n.data;
                }
            }
        }
        if(ceil>key.data){
            return ceil;
        }
        else{
            return root.data;
        }
    }
    public static void main(String[] args) {
        Node a=new Node(8);
        Node b=new Node(3);
        Node c=new Node(12);
        // Node d=new Node(1);
        // Node e=new Node(6);
        // Node f=new Node(14);
        // Node g=new Node(4);
        // Node h=new Node(7);
        // Node i=new Node(13);
        
        a.left=b;
        a.right=c;
        // b.left=d;
        // b.right=e;
        // c.right=f;
        // e.left=g;
        // e.right=h;
        // f.left=i;

        int n=ceil(a,new Node(6));
        System.out.println(n);
    }
}
