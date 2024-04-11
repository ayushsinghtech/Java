import java.util.*;
public class MaxWidthOfBT {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static class Tuple{
        Node node;
        int num;
        Tuple(Node node,int num){
            this.node=node;
            this.num=num;
        }
    }

    public static int maxWidth(Node n){
        int max=0;
        if(n==null){
            return max;
        }
        Queue<Tuple>q=new LinkedList<>();
        q.add(new Tuple(n,0));

        while(!q.isEmpty()){
            int size=q.size();
            int first=0;
            int last=0;
            int min=q.peek().num;
            
            for(int i=0;i<size;i++){
                Tuple top=q.remove();
                Node node=top.node;
                int num=top.num;
                int index=num-min;

                if(i==0){
                    first=top.num;
                }
                if(i==size-1){
                    last=top.num;
                }
                if(node.left!=null){
                    q.add(new Tuple(node.left,2*index+1));
                }
                if(node.right!=null){
                    q.add(new Tuple(node.right,2*index+2));
                }
                if(q.peek()!=null)
                System.out.println(q.peek().node.data+","+q.peek().num);

            }
            max=Math.max(max,last-first+1);
        }
        return max;
    }

    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(3);
        Node c=new Node(7);
        Node d=new Node(8);
        Node e=new Node(4);
        
        a.left=b;
        a.right=c;
        b.left=d;
        c.right=e;

        System.out.println(maxWidth(a));
    }
}
