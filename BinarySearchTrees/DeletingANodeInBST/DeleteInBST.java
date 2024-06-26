import java.util.*;

public class DeleteInBST {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static Node delete(Node n,int key){
        if(n==null){
            return null;
        }
        Node curr=n;
        if(curr.data==key){
            return deleteNode(curr);
        }
        while(curr!=null){
            if(curr.data<key ){
                if(curr.right.data==key && curr.right!=null){
                    curr.right=deleteNode(curr.right);
                    break;
                }
                else{
                    curr=curr.right;
                }
            }
            else{
                if(curr.left.data==key && curr.left!=null){
                    curr.left=deleteNode(curr.left);
                    break;
                }
                else{
                    curr=curr.left;
                }
            }
        }
        return n;
    }

    public static Node deleteNode(Node delete){
        if(delete.left==null){
            return delete.right;
        }
        else if(delete.right==null){
            return delete.left;
        }
        else{
            Node l=delete.left;
            Node r=delete.right;
            while(l.right!=null){
                l=l.right;
            }
            l.right=r;
            return l;
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

        Node root=delete(a,4);
        ArrayList<Integer>arr=new ArrayList<>();
        arr=levelOrder(root);
        System.out.println(arr);
    }    
}
