public class MorrisLikeFlattenBT {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static void flattenBT(Node n){
       if(n==null){
            return;
       }
       Node curr=n;
       while(curr!=null){
            if(curr.left!=null){
                Node temp=curr.left;
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
                curr=curr.right;
            }
            else{
                curr=curr.right;
            }
       }
    }
    
    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(5);
        Node d=new Node(3);
        Node e=new Node(4);
        Node f=new Node(6);
        Node g=new Node(7);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.right=f;
        f.left=g;

        flattenBT(a);
        while(a.right!=null){
            System.out.println(a.data);
            a=a.right;
        }
    }     
}
