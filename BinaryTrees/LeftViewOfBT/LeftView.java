import java.util.*;
public class LeftView {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static void leftView(Node n,int l,ArrayList<Integer>arr){
        if(n==null){
            return;
        }
        if(l==arr.size()){
            arr.add(n.data);
        }
        leftView(n.left,l+1,arr);
        leftView(n.right,l+1,arr);
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

        ArrayList<Integer>arr=new ArrayList<>();
        leftView(a,0,arr);
        System.out.println(arr);
    }
}
