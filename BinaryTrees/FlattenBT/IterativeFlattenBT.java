import java.util.*;

public class IterativeFlattenBT {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static Node prev=null;  //define the prev outside the method otherwise prev updated at the end will not be traced by the returning call

    public static void flattenBT(Node n){
        if(n==null){
            return;
        }
        Stack<Node>st=new Stack<>();
        st.push(n);

        while(!st.isEmpty()){
            Node top=st.pop();
            if(top.right!=null){
                st.push(top.right);
            }
            if(top.left!=null){
                st.push(top.left);
            }
            if(!st.isEmpty()){
                top.right=st.peek();
                top.left=null;
            }
        }
    }
    
    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(5);
        Node d=new Node(3);
        Node e=new Node(4);
        Node f=new Node(6);
        Node g=new Node(7);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.right=f;
        f.left=g;

        flattenBT(a);
        while(a.right!=null){
            System.out.println(a.data);
            a=a.right;
        }
    }    
}

