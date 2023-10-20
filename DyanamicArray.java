public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
    
   List<List<Integer>> arr=new ArrayList<>();
   for(int k=0;k<n;k++){
       List<Integer> arr1=new ArrayList<>();
       arr.add(arr1);
   }
 
   List<Integer> ans=new ArrayList<>();

        
        int lastAnswer=0;
       
        for(int i=0;i<queries.size();i++){
            
        if(queries.get(i).get(0)==1)
        {
            int x=queries.get(i).get(1);
            int y=queries.get(i).get(2);
            
            int idx=((x^lastAnswer)%n); 
            arr.get(idx).add(y);
        }
        
        if(queries.get(i).get(0)==2)
        {
            int x=queries.get(i).get(1);
            int y=queries.get(i).get(2);
            
            int idx=((x^lastAnswer)%n);
            int size=arr.get(idx).size();
            
            lastAnswer=arr.get(idx).get(y%size);
            
            ans.add(lastAnswer);
        
        }
      
        }
        return ans;
       
        }