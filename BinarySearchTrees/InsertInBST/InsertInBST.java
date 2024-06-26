import java.util.*;

public class InsertInBST {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static void insertInBST(Node n, Node key){
        if(n==null){
            return;
        }
        Node curr=n;
        while(curr!=null){
            if(curr.data<key.data){
                if(curr.right!=null){
                    curr=curr.right;
                }
                else{
                    curr.right=key;
                    break;
                }
            }
            else{
                if(curr.left!=null){
                    curr=curr.left;
                }
                else{
                    curr.left=key;
                    break;
                }
            }
        }
        return;
    } 
    public static ArrayList<Integer> levelOrder(Node n){
        ArrayList<Integer>arr=new ArrayList<>();
        if(n==null){
            return arr;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(n);
        arr.add(n.data);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node top=q.remove();
                if(top.left!=null){
                    q.add(top.left);
                    arr.add(top.left.data);
                }
                if(top.right!=null){
                    q.add(top.right);
                    arr.add(top.right.data);
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Node a=new Node(4);
        Node b=new Node(2);
        Node c=new Node(7);
        Node d=new Node(1);
        Node e=new Node(3);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;

        insertInBST(a,new Node(5));
        ArrayList<Integer>arr=new ArrayList<>();
        arr=levelOrder(a);
        System.out.println(arr);
    }
}
