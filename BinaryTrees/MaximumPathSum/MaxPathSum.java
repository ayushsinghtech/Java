
public class MaxPathSum {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }    

    public static int maxPathSum(Node n){
        int max[]=new int[1];
        findMaxPathSum(n,max);
        return max[0];
    }

    public static int findMaxPathSum(Node n,int max[]){
        if(n==null){
            return 0;
        }

        int leftsum=Math.max(0,findMaxPathSum(n.left,max));
        int rightsum=Math.max(0,findMaxPathSum(n.right,max));

        max[0]=Math.max(max[0],n.data+leftsum+rightsum);
        return n.data+Math.max(leftsum,rightsum);
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

        System.out.println(maxPathSum(a));
    }
}
