import java.util.*;


public class BalancedTree {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }

    public static boolean isBalanced(Node n){
        return checkBalanced(n)!=-1;
    }

    public static int checkBalanced(Node n){
        if(n==null){
            return 0;
        }
        int leftht=checkBalanced(n.left);
        int rightht=checkBalanced(n.right);

        if(Math.abs(leftht-rightht)>1){
            return -1;
        }
        if(checkBalanced(n.left)==-1||checkBalanced(n.right)==-1){
            return -1;
        }
        return 1+Math.max(leftht,rightht);
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

        System.out.println(isBalanced(a));
    }
}

