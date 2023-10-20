public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
    // Write your code here
    
    List<Integer> ans=new ArrayList<>();
    
    for(int i=0;i<queries.size();i++){
        
        int count=0;
        for(String s:stringList){
            
            if(queries.get(i).equals(s)){
                count++;
            }  
        }
        ans.add(count);
    }
    return ans;
    

    }