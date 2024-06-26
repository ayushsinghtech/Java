public class KthSmallest {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public static void helper(Node n, int k, int count[],int res[]){
        if(n==null){
            return;
        }
        helper(n.left,k,count,res);
        count[0]++;
        if(k==count[0]){
            res[0]=n.data;
            // System.out.println(res[0]);
            return;
        }
        helper(n.right,k,count,res);
    }
    public static int kSmallest(Node n, int k){
        int count[]=new int[1];
        int res[]=new int[1];
        helper(n,k,count,res);
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
        
        int res=kSmallest(c,5);
        System.out.println(res);
    }    
}
