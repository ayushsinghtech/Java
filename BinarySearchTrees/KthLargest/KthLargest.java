public class KthLargest {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public static void reverseInorder(Node n, int k, int count[], int res[]){
        if(n==null)
        {
            return;
        }
        reverseInorder(n.right,k,count,res);
        count[0]++;
        if(count[0]==k){
            res[0]=n.data;
            return;
        }
        reverseInorder(n.left,k,count,res);
    }

    public static int kthLargest(Node n, int k){
        int count[]=new int[1];
        int res[]=new int[1];
        reverseInorder(n, k, count, res);
        return res[0];
    }

    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        
        c.left=b;
        c.right=d;
        b.left=a;
        d.right=e;
        
        System.out.println(kthLargest(c, 5));
    }
    
}
