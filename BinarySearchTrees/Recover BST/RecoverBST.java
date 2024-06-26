import java.util.*;

public class RecoverBST {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }   

    private static Node first;
    private static Node last;
    private static Node middle;
    private static Node prev;
    
    public static void recoverBST(Node n){
        if(n==null){
            return;
        }
        recoverBST(n.left);
        if(prev!=null && n.data<prev.data){
            if(first==null){
                first=prev;  
                middle=n;
            }
            else{
                last=n;
            }
        }
        prev=n;
        recoverBST(n.right);
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
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);

        c.left=d;
        c.right=b;
        d.left=a;

        inorder(c);
        first=null;
        prev=new Node(Integer.MIN_VALUE);
        middle=null;
        last=null;
        recoverBST(c);
        
        if(first!=null && last!=null){
            int temp=first.data;
            first.data=last.data;
            last.data=temp;
        }
        else if(first!=null && middle!=null){
            int temp=first.data;
            first.data=middle.data;
            middle.data=temp;
        }

        inorder(c);
    }
}
