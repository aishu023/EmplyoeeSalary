
    public static int fourthBit(int number) {
        
        String binaryString = Integer.toBinaryString(number);

        // Step 2: Find the value of the 4th least significant digit in the binary representation
        // Check if the binaryString length is greater than or equal to 4
        if (binaryString.length() >= 4) {
            // Get the character at index 4 from the right (0-based index)
            char fourthDigit = binaryString.charAt(binaryString.length() - 4);
            // Convert the character to an integer and return it
            return Character.getNumericValue(fourthDigit);
        } else {
            // If the binary representation is shorter than 4 digits, return 0
            return 0;
        }


    }



