import java.util.*;
public class Naive {

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }   

    public static int kSmallest(Node n,int k){
        ArrayList<Integer>arr=new ArrayList<>();
        inorder(n,arr);
        if(n==null){
            return -1;
        }
        return arr.get(k-1);
    }

    public static void inorder(Node n, ArrayList<Integer>arr){
        if(n==null){
            return;
        }
        inorder(n.left, arr);
        arr.add(n.data);
        inorder(n.right, arr);
    }

    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        
        c.left=b;
        c.right=d;
        b.left=a;
        d.right=e;

        System.out.println(kSmallest(c,4));
    }
}

