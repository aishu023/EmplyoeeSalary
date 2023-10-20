public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // Write your code here
    
    List<Long> arr=new ArrayList<>(n);
    
    for(int i=0;i<n;i++){
        arr.add(0l);
    }
    
    long max=0;
    
    for(int i=0;i<queries.size();i++){
        
        int start=(queries.get(i).get(0))-1;
        int end=queries.get(i).get(1);
        int value=queries.get(i).get(2);
        
        
        arr.set(start,(arr.get(start)+value));
        
        if(end<n){
            arr.set(end,(arr.get(end)-value));
        }        
      
    }
    
    long curr=0;
    for(int i=0;i<n;i++){
        curr+=arr.get(i);
        max=Math.max(curr,max);
    }
    
    return max;

    }