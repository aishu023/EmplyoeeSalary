 public static List<Integer> getOneBits(int n) {
   
        int count=0;
        String binaryStr = Integer.toBinaryString(n);
        StringBuilder binaryRepr = new StringBuilder(binaryStr);
        

        
        int countOnes = 0;
        List<Integer> positions = new ArrayList<>();

        
        for (int i = 0; i < binaryRepr.length(); i++) {
            
            if (binaryRepr.charAt(i) == '1') {
                // countOnes++;
                count++;
                positions.add(i + 1); 
            }
        }


       positions.add(0,count);

        return positions;
    }