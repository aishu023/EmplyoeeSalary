public static String gridChallenge(List<String> grid) {
        int size = grid.size();
        char[][] gridArray = new char[size][size];
        
        for(int i = 0; i< size ;i++){
            gridArray[i] = grid.get(i).toCharArray();
            Arrays.sort(gridArray[i]);
        }
        
        for(int i =0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(gridArray[j][i]<gridArray[j-1][i]){
                    return "NO";
                }
            }
        }
        return "YES";
    }