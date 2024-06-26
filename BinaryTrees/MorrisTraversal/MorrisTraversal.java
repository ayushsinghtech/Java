import java.util.*;

public class MorrisTraversal {//(Inorder)
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static ArrayList<Integer> morrisTraversal(Node n){
        ArrayList<Integer>arr=new ArrayList<>();
        if(n==null){
            return arr;
        }
        Node curr=n;
        while(curr!=null){
        if(curr.left==null){
            arr.add(curr.data);
            curr=curr.right;
        }
        else{
            Node temp=curr.left;
            System.out.println(temp.data);
            while(temp.right!=null && temp.right!=curr){
                temp=temp.right;
                System.out.println(temp.data);
            }
            if(temp.right==null){
                temp.right=curr;
                curr=curr.left;
            }
            else{
                temp.right=null;
                arr.add(curr.data);
                curr=curr.right;
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
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        e.right=f;

        ArrayList<Integer>arr=new ArrayList<>();
        arr=morrisTraversal(a);
        System.out.println(arr);
    }    
}
