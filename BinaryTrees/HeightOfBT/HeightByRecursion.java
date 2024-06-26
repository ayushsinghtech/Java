import java.util.*;
public class HeightByRecursion {

    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }

    public static int height(Node n){
        if(n==null){
            return 0;
        }
        int left=height(n.left);
        int right=height(n.right);

        return 1+Math.max(left,right);
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

        System.out.println(height(a));
    }
    
}
