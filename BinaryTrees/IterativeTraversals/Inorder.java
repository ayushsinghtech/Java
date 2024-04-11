import java.util.*;

public class Inorder {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }

    public static ArrayList<Integer> inorder(Node n){
        Stack<Node> st=new Stack<>();
        st.push(n);

        ArrayList<Integer>arr=new ArrayList<>();
        if(n==null){
            return arr;
        }
        while(!st.isEmpty()){
            Node top= st.peek();
            if(top.left!=null){
                st.push(top.left);
                top.left=null;
            }
            else{
                Node temp=st.pop();
                arr.add(temp.data);
                if(temp.right!=null){
                    st.push(temp.right);
                    temp.right=null;
                }
            }
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
        ans=inorder(a);

        for(int i:ans){
            System.out.println(i);
        }
    }
}
