
public class SameBT {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }    

    public static boolean isSame(Node n1,Node n2){
        if(n1==null||n2==null){
            return n1==n2;
        }
        return (n1.data==n2.data) && (isSame(n1.left,n2.left)) && (isSame(n1.right,n2.right));      //preorder traversal
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

        System.out.println(isSame(a,a));
    }

}
