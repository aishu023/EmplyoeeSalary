public static int changeAds(int base10) {
        
   int highestOneBitIndex = 0;
        int temp = base10;
        while (temp > 0) {
            highestOneBitIndex++;
            temp /= 2;
        }

        // Step 2: Create a binary number with all bits after highest-order 1 bit set to 1
        int mask = (1 << highestOneBitIndex) - 1;

        // Step 3: Flip the bits after the highest-order 1 bit to the most significant bit
        int result = base10 ^ mask;

        return result;


    }