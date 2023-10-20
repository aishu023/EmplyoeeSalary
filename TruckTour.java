public static int truckTour(List<List<Integer>> petrolpumps) {
    // Write your code here
        int position =0;
        int fuel =0;
        
        for(int i =0;i<petrolpumps.size();i++){
            fuel += petrolpumps.get(i).get(0)- petrolpumps.get(i).get(1);
            
            if(fuel < 0){
                position = i+1;
                fuel=0;
            } 
        }
            return position;
    }