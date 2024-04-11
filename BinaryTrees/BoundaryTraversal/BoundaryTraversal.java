import java.util.*;
public class BoundaryTraversal {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }    

    public static boolean isLeaf(Node n){
        return (n.left==null && n.right==null);
    }
    public static void leftBoundary(Node n,ArrayList<Integer>arr){
        if(n.left!=null && !isLeaf(n.left)){
            n=n.left;
            arr.add(n.data);
        }
        else if(n.right!=null && !isLeaf(n.right)){
            n=n.right;
            arr.add(n.data);
        }
    }
    public static void leafNodes(Node n,ArrayList<Integer>arr){
        if(n==null){
            return;
        }
        if(isLeaf(n)){
            arr.add(n.data);
        }
        leafNodes(n.left,arr);
        leafNodes(n.right,arr);
    }
    public static void rightBoundary(Node n,ArrayList<Integer>arr){
        Stack<Integer>st=new Stack<>();
        if(n.right!=null && !isLeaf(n.right)){
            st.push(n.right.data);
        }
        else if(n.left!=null && !isLeaf(n.left)){
            st.push(n.left.data);
        }
        while(!st.isEmpty()){
            arr.add(st.pop());
        }
    }

    public static ArrayList<Integer> boundaryTraversal(Node n){
        ArrayList<Integer>arr=new ArrayList<>();
        if(n==null){
            return arr;
        }
        arr.add(n.data);
        leftBoundary(n,arr);
        leafNodes(n,arr);
        rightBoundary(n,arr);

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

        ArrayList<Integer>arr=new ArrayList<>();
        arr=boundaryTraversal(a);
        System.out.println(arr);
    }
}
