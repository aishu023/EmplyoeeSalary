public static String caesarCipher(String s, int k) {
    // Write your code here
        char[] sArr = s.toCharArray();
        String str="";
        
        for(char a : sArr){
            if(Character.isLetter(a)){
                char base = Character.isUpperCase(a) ? 'A' : 'a';
                a = (char) (base + (a - base + k) % 26);
            }
            str=str.substring(0)+a;
        } 
        
        return str;
    }