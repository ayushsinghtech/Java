import java.util.*;

public class ChildrenSumProperty {

    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static void childrenSumProperty(Node n){
        if(n==null){
            return;
        }
        int sum=0;
        if(n.left!=null){
            sum+=n.left.data;
        }
        if(n.right!=null){
            sum+=n.right.data;
        }
        if(n.data<=sum){
            n.data=sum;
        }
        else{//n.data>sum
            if(n.left!=null){
                n.left.data=n.data;
            }
            if(n.right!=null){
                n.right.data=n.data;
            }
        }
        childrenSumProperty(n.left);
        childrenSumProperty(n.right);

        int total=0;
        if(n.left!=null){
            total+=n.left.data;
        }
        if(n.right!=null){
            total+=n.right.data;
        }
        if(n.data<total){
            n.data=total;
        }
    }

    public static ArrayList<ArrayList<Integer>> inorder(Node n){
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        if(n==null){
            return arr;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer>temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node top=q.remove();
                temp.add(top.data);
                if(top.left!=null){
                    q.add(top.left);
                }
                if(top.right!=null){
                    q.add(top.right);
                }
            }
            arr.add(temp);
        }
        return arr;
    }

    public static void main(String[] args) {
        Node a=new Node(2);
        Node b=new Node(35);
        Node c=new Node(10);
        Node d=new Node(2);
        Node e=new Node(3);
        Node f=new Node(5);
        Node g=new Node(2);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=g;

        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        arr=inorder(a);
        System.out.println(arr);
        childrenSumProperty(a);
        arr=new ArrayList<>();
        arr=inorder(a);
        System.out.println(arr);
    }    
}
