import java.util.*;

public class Preorder{

    public static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data){
            this.data = data;
        }
    }


    public static ArrayList<Integer> iterativePreorder(Node n){
        ArrayList<Integer> arr= new ArrayList<>();
        Stack<Node> st=new Stack<>();
        if(n==null){
            return arr;
        }
        st.push(n);
        while(!st.isEmpty()){
            Node top=st.peek();
            arr.add(st.pop().data);
            if(top.right!=null){
                st.push(top.right);
            }
            if(top.left!=null){
                st.push(top.left);
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(7);
        Node d=new Node(3);
        Node e=new Node(4);
        Node f=new Node(5);
        Node g=new Node(6);

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        e.left=f;
        e.right=g;

        ArrayList<Integer> res= new ArrayList<>();
        res = iterativePreorder(a);
        System.out.println(res);
    }
}