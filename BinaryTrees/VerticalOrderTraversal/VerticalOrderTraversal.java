import java.util.*;
public class VerticalOrderTraversal {

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
        int l;

        Tuple(Node n,int v,int l){
            this.n=n;
            this.v=v;
            this.l=l;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(Node n){
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        if(n==null){
            return arr;
        }
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp=new TreeMap<>();
        Queue<Tuple>q=new LinkedList<>();
        q.add(new Tuple(n,0,0));

        while(!q.isEmpty()){
            Tuple top=q.remove();
            Node node=top.n;
            int v=top.v;
            int l=top.l;
            if(!mp.containsKey(v)){
                mp.put(v,new TreeMap<>());
            }
            if(!mp.get(v).containsKey(l)){
                mp.get(v).put(l,new PriorityQueue<>());
            }
            mp.get(v).get(l).add(node.data);        //add node in priority queue 
            if(node.left!=null){
                q.add(new Tuple(node.left,v-1,l+1));
            }
            if(node.right!=null){
                q.add(new Tuple(node.right,v+1,l+1));
            }
        }
            for(TreeMap<Integer,PriorityQueue<Integer>> i:mp.values()){
                // ArrayList<Integer>arr1=new ArrayList<>();
                arr.add(new ArrayList<>());
                for(PriorityQueue<Integer>pq:i.values()){
                    while(!pq.isEmpty()){
                        System.out.println(pq.peek());
                        arr.get(arr.size()-1).add(pq.remove());
                    }
                }
                // arr.add(arr1);
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
        arr=verticalOrderTraversal(a);

        System.out.println(arr);
    }
}
