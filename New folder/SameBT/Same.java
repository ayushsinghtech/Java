import java.util.*;

public class Same {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
        }
    }

    // public static int helper(Node n){
    //     int arr[]=new int[1];
    //     maxPathSum(n,arr);
    //     return arr[0];
    // }
    
    public static boolean same(Node n1, Node n2){
        if(n1==null || n2==null){
            return n1==n2;
        }
        boolean left=same(n1.left, n2.left);
        boolean right= same(n1.right, n2.right);
        
        return (n1.data!=n2.data) && left && right;
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

        System.out.println(same(a,b));
    }
}
    

    
