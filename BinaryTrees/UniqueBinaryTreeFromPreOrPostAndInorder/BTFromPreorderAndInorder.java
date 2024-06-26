import java.util.*;
public class BTFromPreorderAndInorder {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    
    public static Node makeBTFromInorderPreorder(ArrayList<Integer>Inorder,int istart,int iend, ArrayList<Integer>Preorder,int prestart,int preend){
        HashMap<Integer,Integer>mp=new HashMap<>();        
        for(int i=0;i<Inorder.size();i++){
            int temp=Inorder.get(i);
            mp.put(temp,i);
        }
        return makeBT(Inorder,istart,iend,Preorder,prestart,preend,mp);
    }
    
    public static Node makeBT(ArrayList<Integer>Inorder,int istart,int iend, ArrayList<Integer>Preorder,int prestart,int preend,HashMap<Integer,Integer>mp){
        if(istart>iend || prestart>preend){
            return null;
        }
        Node n=new Node(Preorder.get(prestart));
        int element=Preorder.get(prestart);
        
        int index=mp.get(element);
        int left=index-istart;

        n.left=makeBT(Inorder, istart, index-1, Preorder, prestart+1, prestart+left, mp);
        n.right=makeBT(Inorder, index+1, iend, Preorder, prestart+left+1, preend, mp);
        return n;
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
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        Node h=new Node(8);
        Node i=new Node(9);
        Node j=new Node(10);
        Node k=new Node(11);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=g;
        d.left=h;
        d.right=i;
        e.left=j;
        e.right=k;

        ArrayList<Integer>Preorder=new ArrayList<>();
        Preorder.add((10));
        Preorder.add((20));
        Preorder.add((40));
        Preorder.add((50));
        Preorder.add((30));
        Preorder.add((60));

        ArrayList<Integer>Inorder=new ArrayList<>();
        Inorder.add((40));
        Inorder.add((20));
        Inorder.add((50));
        Inorder.add((10));
        Inorder.add((60));
        Inorder.add((30));

        Node n=makeBTFromInorderPreorder(Inorder,0,Inorder.size()-1,Preorder,0,Preorder.size()-1);
        ArrayList<Integer>arr=new ArrayList<>();
        arr=levelOrder(n);
        System.out.println(arr);
    }    
}
