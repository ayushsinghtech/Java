import java.util.*;
public class ZigZagTraversal {
    
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }    

    public static ArrayList<ArrayList<Integer>> zigZag(Node n){
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        if(n==null){
            return arr;
        }

        Queue<Node>q=new LinkedList<>();
        q.add(n);
        boolean leftToRight=true;
        
        while(!q.isEmpty()){
            int len=q.size();
            ArrayList<Integer>temp=new ArrayList<>(len);
            for(int i=0;i<len;i++){
                temp.add(i,0);
            }
            for(int i=0;i<len;i++){
                Node top=q.remove();
                int index=(leftToRight)? i:(len-1-i);
                temp.set(index,top.data);
                if(top.left!=null){
                    q.add(top.left);
                }
                if(top.right!=null){
                    q.add(top.right);
                }
            }
            leftToRight=!leftToRight;
            arr.add(temp);
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

        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        arr=zigZag(a);
        System.out.println(arr);
    }    
}
