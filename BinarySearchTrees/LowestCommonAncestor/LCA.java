public class LCA {
        public static class Node{
            int data;
            Node left;
            Node right;
            public Node(int data){
                this.data=data;
            }
        }
    
        public static int LCA(Node n, int a, int b){
            if(n==null){
                return -1;
            }
            if(a<n.data && b<n.data){
                return LCA(n.left,a,b);
            }
            else if(a>n.data && b>n.data){
                return LCA(n.right,a,b);
            }
            return n.data;
        }

        public static void main(String[] args) {
            Node a=new Node(10);
            Node b=new Node(4);
            Node c=new Node(13);
            Node d=new Node(3);
            Node f=new Node(8);
            Node g=new Node(11);
            Node h=new Node(15);
            Node i=new Node(1);
            Node j=new Node(6);
            Node k=new Node(9);
            Node l=new Node(2);
            Node m=new Node(5);
            Node n=new Node(7);
            
            a.left=b;
            a.right=c;
            b.left=d;
            b.right=f;
            c.left=g;
            c.right=h;
            c.right=d;
            d.left=i;
            f.left=j;
            f.right=k;
            i.right=l;
            j.left=m;
            j.right=n;

            System.out.println(LCA(a, 5, 9));
        }
        
    }
    
