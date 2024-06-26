import java.util.*;

public class BinaryTreeFromPostAndInorder {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    
    public static Node makeBTFromPostorderAndInorder(ArrayList<Integer>postorder,int poststart,int postend,ArrayList<Integer>inorder,int instart,int inend){
        HashMap <Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<inorder.size();i++){
            mp.put(inorder.get(i),i);
        }
        return makeBT(postorder,poststart,postend,inorder,instart,inend,mp);
    }

    public static Node makeBT(ArrayList<Integer>postorder,int poststart,int postend,ArrayList<Integer>inorder,int instart,int inend,HashMap<Integer,Integer>mp){
        if(instart>inend || poststart>postend){
            return null;
        }
        
        Node root=new Node(postorder.get(postend));
        int n=postorder.get(postend);
        System.out.println(mp.get(n));

        int index=mp.get(n);
        int left=index-instart;

        root.left=makeBT(postorder, poststart, poststart+left-1, inorder, instart,index-1, mp);
        root.right=makeBT(postorder, poststart+left, postend-1, inorder, index+1,inend, mp);

        return root;
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
        ArrayList<Integer>Postorder=new ArrayList<>();
        Postorder.add((40));
        Postorder.add((50));
        Postorder.add((20));
        Postorder.add((60));
        Postorder.add((30));
        Postorder.add((10));

        ArrayList<Integer>Inorder=new ArrayList<>();
        Inorder.add((40));
        Inorder.add((20));
        Inorder.add((50));
        Inorder.add((10));
        Inorder.add((60));
        Inorder.add((30));

        Node n=makeBTFromPostorderAndInorder(Postorder,0,Postorder.size()-1,Inorder,0,Inorder.size()-1);
        ArrayList<Integer>arr=new ArrayList<>();
        arr=levelOrder(n);
        System.out.println(arr);
    }    
}    

