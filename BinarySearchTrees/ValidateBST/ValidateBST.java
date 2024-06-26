public class ValidateBST {
        public static class Node{
            int data;
            Node left;
            Node right;
            public Node(int data){
                this.data=data;
            }
        }
    
       public static boolean validateBST(Node n,int min,int max){
            if(n==null){
                return true;
            }
            boolean left=validateBST(n.left,min,n.data);
            boolean right=validateBST(n.right,n.data,max);
            if(!(n.data>=min && n.data<max)){
                return false;
            }
            return left && right;
       }
    
        public static void main(String[] args) {
            Node a=new Node(1);
            Node b=new Node(2);
            Node c=new Node(3);
            Node d=new Node(4);
            Node e=new Node(5);
            
            c.left=b;
            c.right=e;
            b.left=a;
            e.right=d;
            
            System.out.println(validateBST(c,Integer.MIN_VALUE,Integer.MAX_VALUE));
        }
        
}
    
