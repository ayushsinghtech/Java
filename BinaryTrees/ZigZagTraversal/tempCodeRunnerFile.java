    // public static ArrayList<ArrayList<Integer>> zigZag(Node n){
    //     ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
    //     if(n==null){
    //         return arr;
    //     }

    //     Queue<Node>q=new LinkedList<>();
    //     q.add(n);
    //     boolean leftToRight=true;
        
    //     while(!q.isEmpty()){
    //         int len=q.size();
    //         // System.out.println(q.size());
    //         ArrayList<Integer>temp=new ArrayList<>(len);
    //         // int count=0;
    //         for(int i=0;i<len;i++){
    //             Node top=q.remove();
    //             // int index=(leftToRight)? i:(size-1-i);
    //             int index;
    //             if(leftToRight){
    //                 index=i;   
    //             }
    //             else{
    //                 index=len-1-i;
    //             }
    //             System.out.println(len);
    //             temp.add(index,top.data);
    //             if(top.left!=null){
    //                 q.add(top.left);
    //             }
    //             if(top.right!=null){
    //                 q.add(top.right);
    //             }
    //             // System.out.println(temp);
    //         }
    //         leftToRight=!leftToRight;
    //         arr.add(temp);
    //         // count++;
    //         // System.out.println(count);
    //         // System.out.println(arr);
    //     }
    //     return arr;
    // }
