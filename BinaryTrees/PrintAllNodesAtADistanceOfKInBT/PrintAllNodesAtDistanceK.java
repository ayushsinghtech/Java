public class PrintAllNodesAtDistanceK{
    
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    } 

    public static void initialiseParent(Node n,TreeMap<Node,Node>mp){
        if(n==null){
            return;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node top=q.remove();
                if(top.left!=null){
                    mp.put(top.left,top);
                    q.add(top.left);
                }
                if(top.right!=null){
                    mp.put(top.right,top);
                    q.add(top.right);
                }
            }
        }
    }

    public static void printNodesAtDistanceK(Node n,int dis, Node target){
        ArrayList<Integer>arr=new ArrayList<>();
        if(n==null){
            return arr;
        }
        TreeMap<Node,Node>mp=new TreeMap<>();
        initialiseParent(n,mp);
        Node curr=target;
        Queue<Node>q=new LinkedList<>();
        q.add(curr);
        int temp=0;
        while(!q.isEmpty()){
            int size=q.size();
            int flag=0;
            for(int i=0;i<size;i++){
                if(temp==size){
                    break;
                }
                Node top=q.remove();
                if(mp.get(top)!=null){
                    q.add(mp.get(top));
                    flag=1;
                }
                if(top.left!=null){
                    q.add(top.left);
                    flag=1;
                }
                if(top.right!=null){
                    q.add(top.right);
                    flag=1;
                }
            }
            if(flag==1){
                temp++;
            }
        }
        while(!q.isEmpty()){
            arr.add(q.remove().data);
        }
        return arr;
    }
    public static void main(String[] args) {
        Node a=new Node(3);
        Node b=new Node(5);
        Node c=new Node(1);
        Node d=new Node(6);
        Node e=new Node(2);
        Node f=new Node(0);
        Node g=new Node(8);
        Node h=new Node(7);
        Node i=new Node(4);
        
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=g;
        e.left=h;
        e.right=i;

        ArrayList<Integer>arr=new ArrayList<>();
        arr=printNodesAtDistanceK(a,2,b);
        System.out.println(arr);
    }
}