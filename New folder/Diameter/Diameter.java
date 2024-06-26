import java.util.*;

public class Diameter{

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
        }
    }

    public static int helper(Node n){
        int arr[]=new int[1];
        diameter(n,arr);
        return arr[0]+1;
    }
    
    public static int diameter(Node n, int arr[]){
        if(n==null){
            return 0;
        }
        int left=diameter(n.left,arr);
        int right=diameter(n.right,arr);

        int dia=left+right;
        arr[0]=Math.max(dia,arr[0]);

        return 1+Math.max(left,right);
    }

    public static void main(String[] args) {
        
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(7);
        Node f=new Node(5);
        Node g=new Node(8);
        Node h=new Node(6);
        Node i=new Node(9);

        a.left=b;
        a.right=c;
        c.left=d;
        c.right=e;
        d.right=f;
        e.right=g;
        f.left=h;
        g.right=i;

        System.out.println(helper(a));
    }
}