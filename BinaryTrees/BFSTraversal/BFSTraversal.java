import java.util.*;
public class BFSTraversal {

    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }

    // first add, then removef
    public static ArrayList<ArrayList<Integer>> BFS(Node n){
        Queue <Node> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(n==null){
            return res;
        }
        q.add(n);
        
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> a=new ArrayList<>();
            for(int i=0;i<size;i++){
                if(q.peek().left!=null){
                  q.add(q.peek().left);                  
                }
                if(q.peek().right!=null){ 
                    q.add(q.peek().right);
                }
                a.add(q.remove().data);
            }   
            res.add(a);
        }
        return res;
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

        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans=BFS(a);

        for(ArrayList<Integer> i:ans){
            System.out.println(i);
        }
    }
}
