import java.util.*;

public class VerticalView {
        public static class Node{
            int data;
            Node left;
            Node right;
    
            public Node(int data){
                this.data=data;
            }
        }

        public static class Tuple{
            Node n;
            int v;
            int l;
            public Tuple(Node n,int v,int l){
                this.n=n;
                this.v=v;
                this.l=l;
            }
        }

        public static ArrayList<ArrayList<Integer>> verticalTraversal(Node n){
            TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp = new TreeMap<>();
            
            ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
            Queue<Tuple> q=new LinkedList<>();
            q.add(new Tuple(n,0,0));

            while(!q.isEmpty()){
                Tuple top= q.remove();
                Node node=top.n;
                int v=top.v;
                int l=top.l;

                if(!mp.containsKey(v)){
                    mp.put(v,new TreeMap<>());
                }
                if(!mp.get(v).containsKey(l)){
                    mp.get(v).put(l,new PriorityQueue<>());
                }
                mp.get(v).get(l).add(node.data);

                   if(node.left!=null){
                        q.add(new Tuple(node.left,v-1,l+1));
                    }
                    if(node.right!=null){
                        q.add(new Tuple(node.right,v+1,l+1));
                    }
            }

            for(TreeMap<Integer,PriorityQueue<Integer>>i: mp.values()){
                arr.add(new ArrayList<>());
                for(PriorityQueue<Integer>pq:i.values()){
                    while(!pq.isEmpty()){
                        arr.get(arr.size()-1).add(pq.remove());
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
            Node e=new Node(10);
            Node f=new Node(9);
            Node g=new Node(10);
            Node h=new Node(5);
            Node i=new Node(6);
    
            a.left=b;
            a.right=c;
            b.left=d;
            b.right=e;
            c.left=f;
            c.right=g;
            d.right=h;
            h.right=i;
    
            ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
            arr=verticalTraversal(a);
            System.out.println(arr);
        }
    }
        
    
        
        

