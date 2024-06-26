import java.util.*;
public class Searching {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static Node search(Node n,Node key){
        if (n==null){
            return null;
        }
        while(n!=null && n.data!=key.data){
            n=n.data<key.data? n.right:n.left;
        }
        return n;
    }
    public static void main(String[] args) {
        Node a=new Node(3);
        Node b=new Node(5);
        Node c=new Node(1);
        Node d=new Node(6);
        Node e=new Node(2);
        Node f=new Node(0);
        Node g=new Node(8);
        Node h=new Node(7);
        Node i=new Node(4);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=g;
        e.left=h;
        e.right=i;

        Node n=search(a,new Node(8));
        if(n!=null){
            System.out.println(n.data);
        }
        else{
            System.out.println(n);
        }
    }
}
