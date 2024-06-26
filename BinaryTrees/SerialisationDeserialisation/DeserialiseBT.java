import java.util.*;
public class DeserialiseBT {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 
    public static Node deserialiseBT(String s){
        if(s==""){
            return null;
        }
        String arr[]=s.split(",");
        Node root=new Node(Integer.parseInt(arr[0]));
        int curr=1;
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){        
            int size=q.size();
            for(int i=0;i<size;i++){
                Node top=q.remove();
                if(!arr[curr].equals("#")){
                    top.left=new Node(Integer.parseInt(arr[curr]));
                    q.add(top.left);
                }
                curr++;
                if(!arr[curr].equals("#")){
                    top.right=new Node(Integer.parseInt(arr[curr]));
                    q.add(top.right);
                }
                curr++;
            }
        }
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
        String s="1,2,3,#,#,4,5,#,#,#,#";
        Node n=deserialiseBT(s);
        ArrayList<Integer>arr=new ArrayList<>();
        arr=levelOrder(n);
        System.out.println(arr);
    }        
}
