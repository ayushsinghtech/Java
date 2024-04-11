import java.util.*;
public class RootToNodePath {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static boolean rootToNodePath(Node n,ArrayList<Integer>arr,Node node){
        if(n==null){
            return false;
        }
        arr.add(n.data);
        if(n==node){
            return true;
        }
        if((rootToNodePath(n.left,arr,node))||(rootToNodePath(n.right,arr,node))){
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
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
        rootToNodePath(a,arr,e);
        System.out.println(arr);
    }    
}
