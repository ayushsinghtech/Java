public class Floortest {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
        }
    }

    public static int floor(Node n, Node key){
        int floor=-1;
        if(n==null){
            return floor;
        }
        while(n!=null){
            if(n.data == key.data){
                return n.data;
            }
            else if(n.data > key.data){
                n=n.left;
            }
            else{
                floor = n.data;
                n=n.right;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
       
        Node a = new Node(10);
        Node b = new Node(5);
        Node c = new Node(15);
        Node d = new Node(2);
        Node e = new Node(6);

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;

        System.out.println(floor(a,new Node(12)));
    }
}
