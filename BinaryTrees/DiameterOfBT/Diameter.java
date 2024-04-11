import java.util.*;

public class Diameter {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }    

    public static int helper(Node n){
        int max[]=new int [1];
        diameter(n,max);
        return max[0];
    }
    public static int diameter(Node n,int max[]){
        if(n==null){
            return 0;
        }
        int left=diameter(n.left,max);
        int right=diameter(n.right,max);

        max[0]=Math.max(max[0],left+right);
        
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

        System.out.println(helper(a));
    }
}
