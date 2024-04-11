import java.util.*;

public class HeightByLevelOrder{
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }

    public static int height(Node n){
        Queue<Node>q =new LinkedList<>();
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        if(n==null){
            return 0;
        }
        q.add(n);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer>temp=new ArrayList<>();
            while(size!=0){
                Node top=q.peek();
                if(top.left!=null){
                    q.add(top.left);
                }
                if(top.right!=null){
                    q.add(top.right);
                }
                temp.add(q.remove().data);
                size--;
            }
            arr.add(temp);
        }
        return arr.size();
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

        System.out.println(height(a));
    }
}
