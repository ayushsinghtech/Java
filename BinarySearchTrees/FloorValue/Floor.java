import java.util.*;
public class Floor{
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static int floor(Node n,Node key){
        int floor=-1;
        if(n==null){
            return floor;
        }
        Node curr=n;
        while(curr!=null){
            if(curr.data==key.data){
                return curr.data;
            }
            else if(curr.data<key.data){
                floor=curr.data;
                curr=curr.right;
            }
            else{
                curr=curr.left;
            }
        }
        return floor;
    }
    public static void main(String[] args) {
        Node a=new Node(8);
        Node b=new Node(3);
        Node c=new Node(12);
        Node d=new Node(1);
        Node e=new Node(6);
        Node f=new Node(14);
        Node g=new Node(4);
        Node h=new Node(7);
        Node i=new Node(13);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.right=f;
        e.left=g;
        e.right=h;
        f.left=i;

        int n=floor(a,new Node(4));
        System.out.println(n);
    }
}