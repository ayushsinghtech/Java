import java.util.ArrayList;
import java.util.Stack;

public class Postorder2Stack {

    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }

    public static ArrayList<Integer> postorder(Node n){
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();
        
        ArrayList<Integer>arr=new ArrayList<>();
        if(n==null){
            return arr;
        }

        st1.push(n);
        while(!st1.isEmpty()){
            Node top=st1.pop();
            st2.push(top);

            if(top.left!=null){
                st1.push(top.left);
            }
            if(top.right!=null){
                st1.push(top.right);
            }
        }

        while(!st2.isEmpty()){
            arr.add(st2.pop().data);
        }

        return arr;
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

        ArrayList<Integer> ans=new ArrayList<>();
        ans=postorder(a);

        System.out.println(ans);

    }
    
}
