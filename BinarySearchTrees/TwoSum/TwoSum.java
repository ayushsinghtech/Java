import java.util.*;

public class TwoSum {
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
        private static Stack<Node>st;
        public Iterator(Node n, boolean next){
            this.n=n;
            this.next=next;
            st=new Stack<>();
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

    public static ArrayList<Integer> twoSum(Node n, int key){
        ArrayList<Integer>arr=new ArrayList<>();
        if(n==null){
            return arr;
        }

        Iterator l=new Iterator(n,true);
        Iterator r=new Iterator(n.right,false);

        int left=l.next();
        System.out.println(left);
        int right=r.next();
        System.out.println(right);

        while(left<right){
            if(left+right<key){
                System.out.println(left+right+" smaller");
                left=l.next();
            }
            else if(left+right>key){
                System.out.println(left+right+" greater");
                right=r.next();
            }
            else{
                System.out.println(left+right+" equal");
                arr.add(left);
                arr.add(right);
                return arr;
            }
        }
        return arr;
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

        Iterator it=new Iterator(a,true);
        // Iterator prev=new Iterator(a,false);
        // System.out.println(it.next());
        // System.out.println(prev.next());
        ArrayList<Integer>arr=twoSum(a,3);
        System.out.println(arr);
    }
}


    
        
    
        

