import java.util.*;

public class LargestBST {
    public static class Node{
        int data; 
        Node left;
        Node right;
        
        public Node(int data){
            this.data=data;
        }
    }
    public static class Tuple{
        int size;
        int smallest;
        int largest;
        public Tuple(int size,int smallest,int largest){
            this.size=size;
            this.smallest=smallest;
            this.largest=largest;
        }
    }
       
    public static Tuple largestBST(Node n){
        if(n==null){
            return new Tuple(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        
        Tuple left=largestBST(n.left);
        Tuple right=largestBST(n.right);

        if(n.data>left.largest && n.data<right.smallest){
           return new Tuple(left.size+right.size+1,Math.min(n.data,left.smallest),Math.max(n.data,right.largest));
        }
        else{
           return new Tuple(Math.max(left.size,right.size),Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
    }

    public static void inorder(Node n){
        if(n==null){
            return;
        }
        inorder(n.left);
        System.out.println(n.data);
        inorder(n.right);
    }
    public static void main(String[] args) {
        Node a=new Node(10);
        Node b=new Node(5);
        Node c=new Node(15);
        Node d=new Node(1);
        Node e=new Node(8);
        Node f=new Node(7);

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.right=f;

        System.out.println(largestBST(a).size);
    }
}


