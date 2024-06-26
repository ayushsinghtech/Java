import java.util.*;
public class BSTFromPreorder {
        public static class Node{
            int data;
            Node left;
            Node right;
            public Node(int data){
                this.data=data;
            }
        }

        public static void inorder(Node n){
            if(n==null){
                return;
            }
            inorder(n.left);
            System.out.print(n.data+" ");
            inorder(n.right);
        }

        public static Node bstFromPreorder(List<Integer>preorder, int index[],int ub){
            if(index[0]==preorder.size() || preorder.get(index[0])>ub){
                return null;
            }
            Node n=new Node(preorder.get(index[0]++));
            n.left=bstFromPreorder(preorder,index,n.data);
            n.right=bstFromPreorder(preorder,index,ub);
            return n;
        }
      
        public static void main(String[] args) {
            List<Integer>preorder=Arrays.asList(8,5,1,7,10,11);
            int index[]=new int[1];
            Node root = bstFromPreorder(preorder, index, Integer.MAX_VALUE);
            // System.out.println(root.right.data);
            inorder(root);
        }
        
}
    

    
