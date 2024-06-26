import java.util.*;

public class BSTIterator {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    public static class Iterator{
        Node n;
        public static boolean next;
        public static Stack<Node>st=new Stack<>();
        public Iterator(Node n, boolean next){
            this.n=n;
            this.next=next;
            if(next==true){
                while(n!=null){
                    st.push(n);
                    n=n.left;
               }
            }
            else{
                while(n!=null){
                    st.push(n);
                    n=n.right;
                }
            }
        }

        public static int next(){
            if(st.isEmpty()){
                return -1;
            }
            else{
                Node top=st.pop();
                if(next==true){
                    Node temp=top.right;
                    while(temp!=null){
                        st.push(temp);
                        temp=temp.left;
                    }
                    return top.data;
                }
                else{
                    Node temp=top.left;
                    while(temp!=null){
                        st.push(temp);
                        temp=temp.right;
                    }    
                    return top.data;
                }
            }
        }

        public static boolean hasNext(){
            return !st.isEmpty();
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
        d.left=i;
        f.left=j;
        f.right=k;
        i.right=l;
        j.left=m;
        j.right=n;

        Iterator it=new Iterator(a, false);
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());

    }
}


    
        
    
        
