package BinaryTrees.SerialisationDeserialisation;
import java.util.*;
public class SerialiseBT {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static String serialiseBT(Node n){
        String s="";
        if(n==null){
            return s;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()){
            Node top=q.remove();
            if(top==null){
                s+="#";
                continue;
            }
            else{
                s+=top.data;
            }
            System.out.println(s);
            System.out.println(q);
            q.add(top.left);
            q.add(top.right);
        }
        return s;
    }

    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        
        a.left=b;
        a.right=c;
        c.left=d;
        c.right=e;

        String s=serialiseBT(a);
        System.out.println(s);
    }
}
