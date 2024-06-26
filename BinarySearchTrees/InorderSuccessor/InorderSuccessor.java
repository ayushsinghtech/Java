import java.util.*;
public class InorderSuccessor {
        public static class Node{
            int data;
            Node left;
            Node right;
            public Node(int data){
                this.data=data;
            }
        }

        public static void inorder(Node n){
            if(n==null){
                return;
            }
            inorder(n.left);
            System.out.print(n.data+" ");
            inorder(n.right);
        }

public static void inorderSuccessor(Node n, int key,int res[]){
    if(n==null){
        return;
    }
    if(n.data<=key){
        inorderSuccessor(n.right,key,res);
    }
    else if(n.data>key){
        res[0]=n.data;
        // System.out.println(n.data);
        inorderSuccessor(n.left,key,res);
    }
}      
        public static void main(String[] args) {
            Node a=new Node(10);
            Node b=new Node(4);
            Node c=new Node(13);
            Node d=new Node(3);
            Node f=new Node(8);
            Node g=new Node(11);
            Node h=new Node(15);
            Node i=new Node(1);
            Node j=new Node(6);
            Node k=new Node(9);
            Node l=new Node(2);
            Node m=new Node(5);
            Node n=new Node(7);
            
            a.left=b;
            a.right=c;
            b.left=d;
            b.right=f;
            c.left=g;
            c.right=h;
            c.right=d;
            d.left=i;
            f.left=j;
            f.right=k;
            i.right=l;
            j.left=m;
            j.right=n;
        int res[]=new int[1];
        inorderSuccessor(a,3 ,res);
        System.out.println(res[0]);
        // inorder(c);
    }
}
    

    

