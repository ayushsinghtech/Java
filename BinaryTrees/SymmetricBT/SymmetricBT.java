import java.util.*;
public class SymmetricBT {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 
    
    public static boolean isSymmetric(Node n,Node m){
        if(n==null||m==null){
            return n==m;
        }
        if(n.data!=m.data){
            return false;
        }
        return isSymmetric(n.left,m.right)&&isSymmetric(n.right,m.left);
    }
    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(2);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(5);
        Node g=new Node(6);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=g;

        ArrayList<Integer>arr=new ArrayList<>();
        System.out.println(isSymmetric(a,a));
    }
}
