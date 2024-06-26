import java.util.*;
public class MinTimeToBurnBT {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static void initialiseParent(Node n,HashMap<Node,Node>mp){
        Queue<Node>q=new LinkedList<>();
        if(n==null){
            return;
        }
        q.add(n);
        mp.put(n,null);
        while(!q.isEmpty()){
            Node top=q.remove();
            if(top.left!=null){
                q.add(top.left);
                mp.put(top.left,top);
            }
            if(top.right!=null){
                q.add(top.right);
                mp.put(top.right,top);
            }
        }
    }

    public static int minTimeToBurnBT(Node n){
        int t=0;
        if(n==null){
            return t;
        }
        HashMap<Node,Node>mp=new HashMap<>();
        initialiseParent(n,mp);
        HashMap<Node,Boolean>visited=new HashMap<>();
        Queue<Node>q=new LinkedList<>();
        q.add(n);
        visited.put(n,true);
        while(!q.isEmpty()){
            int size=q.size();
            int flag=0;
            for(int i=0;i<size;i++){
                Node top=q.remove();
                if(top.left!=null && visited.get(top.left)==null){
                    q.add(top.left);
                    visited.put(top.left,true);
                    flag=1;
                }
                if(top.right!=null && visited.get(top.right)==null){
                    q.add(top.right);
                    visited.put(top.right,true);
                    flag=1;
                }
                if(mp.get(top)!=null && visited.get(mp.get(top))==null){
                    q.add(mp.get(top));
                    visited.put(mp.get(top),true);
                    flag=1;
                }
            }
            if(flag==1){
                t++;
            }
        }
        return t;
    }
    public static void main(String[] args) {
        Node a=new Node(3);
            Node b=new Node(5);
            Node c=new Node(1);
            Node d=new Node(6);
            Node e=new Node(2);
            Node f=new Node(0);
            Node g=new Node(8);
            Node h=new Node(7);
            Node i=new Node(4);
            
            a.left=b;
            a.right=c;
            b.left=d;
            b.right=e;
            c.left=f;
            c.right=g;
            e.left=h;
            e.right=i;
    
            System.out.println(minTimeToBurnBT(a));
    }
}
