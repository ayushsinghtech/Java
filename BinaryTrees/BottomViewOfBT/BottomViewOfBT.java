import java.util.*;
public class BottomViewOfBT {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }    

    public static class Tuple{
        Node n;
        int v;
        Tuple(Node n,int v){
            this.n=n;
            this.v=v;
        }
    }
    public static ArrayList<Integer> bottomView(Node n){
        ArrayList<Integer>arr=new ArrayList<>();
        if(n==null){
            return arr;
        }
        Queue<Tuple>q=new LinkedList<>();
        TreeMap<Integer,Integer>mp=new TreeMap<>();
        q.add(new Tuple(n,0));

        while(!q.isEmpty()){
            Tuple top=q.remove();
            Node node=top.n;
            int v=top.v;

            mp.put(v,node.data);
            if(node.left!=null){
                q.add(new Tuple(node.left,v-1));
            }
            if(node.right!=null){
                q.add(new Tuple(node.right,v+1));
            }
        }

        for(int i:mp.values()){
            arr.add(i);
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

        ArrayList<Integer>arr=new ArrayList<>();
        arr=bottomView(a);
        System.out.println(arr);
    }
}

