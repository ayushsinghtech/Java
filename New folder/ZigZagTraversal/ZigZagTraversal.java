
import java.util.*;
public class ZigZagTraversal {
        public static class Node{
            int data;
            Node left;
            Node right;
    
            public Node(int data){
                this.data=data;
            }
        }
    
        public static ArrayList<ArrayList<Integer>> zigZag(Node n){
            Queue<Node>q=new LinkedList<>();
            q.add(n);
            ArrayList<ArrayList<Integer>> arr=new ArrayList<>();

            if(n==null){
                return arr;
            }
            int flag=0; // l to r
            while(!q.isEmpty()){
                int size=q.size();
                ArrayList<Integer>temp=new ArrayList<>();
                for(int i=0;i<size;i++){
                    Node top=q.peek();
                    if(top.left!=null){
                        q.add(top.left);
                    }
                    if(top.right!=null){
                        q.add(top.right);
                    }
                    temp.add(q.remove().data);
                }
                if(flag==0){
                    flag=1;
                    arr.add(temp);
                }
                else{
                    flag=0;
                    Collections.reverse(temp);
                    arr.add(temp);
                }
                
            }
            return arr;
        }
    
        public static void main(String[] args) {
            
            Node a=new Node(1);
            Node b=new Node(2);
            Node c=new Node(3);
            Node d=new Node(4);
            Node e=new Node(7);
            Node f=new Node(5);
            Node g=new Node(8);
            Node h=new Node(6);
            Node i=new Node(9);
    
            a.left=b;
            a.right=c;
            c.left=d;
            c.right=e;
            d.right=f;
            e.right=g;
            f.left=h;
            g.right=i;
    
            ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
            arr=zigZag(a);
            System.out.println(arr);
        }
    }
        
    
        
        
