import java.util.*;

public class PreInPostIn1Traversal {

    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }

    public static class Pair{
        Node node;
        int num;

        Pair(Node node,int num){
            this.node=node;
            this.num=num;
        }    
    }

    public static void preInPost(Node n){
        Stack<Pair> st= new Stack<>();
        st.add(new Pair(n,1));

        ArrayList<Integer> pre=new ArrayList<>();
        ArrayList<Integer> in=new ArrayList<>();
        ArrayList<Integer> post=new ArrayList<>();
        
        if(n==null){
            return;
        }
        
        while(!st.isEmpty()){
            Pair top=st.pop();
            if(top.num==1){
                pre.add(top.node.data);
                top.num++;
                st.push(top);
                // st.push(new Pair(top.node,top.num++));
                if(top.node.left!=null){
                    st.push(new Pair(top.node.left,1));
                }
            }

            else if(top.num==2){
                in.add(top.node.data);
                top.num++;
                st.push(top);
                // st.push(new Pair(top.node,top.num++));
                if(top.node.right!=null){
                    st.push(new Pair(top.node.right,1));
                }
            }

            else{
                post.add(top.node.data);
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
        

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

        preInPost(a);
    }

}
