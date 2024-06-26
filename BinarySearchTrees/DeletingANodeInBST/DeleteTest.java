import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DeleteTest {

    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static Node Helper(Node n, Node key){
        if(n==null){
            return n;
        }
        while(n!=null){
            if(n.data==key.data){
                return delete(n,key);
            }
            else if(n.data < key.data){
                if(n.right!=null && n.right.data==key.data){
                    n.right=delete(n.right,key);
                    break;
                }
                else{
                    n=n.right;
                }
            }
            else{
                if(n.left!=null && n.left.data==key.data){
                    n.left=delete(n.left,key);
                    break;
                }
                else{
                    n=n.left;
                }
            }
        }
        return n;
    }

    public static Node delete(Node n, Node key){
        if(n==null){
            return n;
        }
        Node curr = n;
        if(n.left==null){
            return n.right;
        }
        else if(n.right==null){
            return n.left;
        }
        else{
            Node l=n.left;
            Node r=n.right;

            while(l.right!=null){
                l=l.right;
            }
            l.right = r;
            return curr.left;
        }

    }

    public static ArrayList<Integer> levelOrder(Node n){
        ArrayList<Integer>arr=new ArrayList<>();
        if(n==null){
            return arr;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(n);
        arr.add(n.data);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node top=q.remove();
                if(top.left!=null){
                    q.add(top.left);
                    arr.add(top.left.data);
                }
                if(top.right!=null){
                    q.add(top.right);
                    arr.add(top.right.data);
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Node a=new Node(4);
        Node b=new Node(2);
        Node c=new Node(7);
        Node d=new Node(1);
        Node e=new Node(3);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;

        Node root=delete(a,new Node(4));
        ArrayList<Integer>arr=new ArrayList<>();
        arr=levelOrder(root);
        System.out.println(arr);
    }
    
}
