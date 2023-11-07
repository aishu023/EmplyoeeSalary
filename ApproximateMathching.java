
public static String calculateScore(String text, String prefixString, String suffixString) {
    int n = text.length();
    int n1 = prefixString.length();
    int n2 = suffixString.length();
    int textScore = 0;
    String ans = "";

    long p = 31;
    long mod = 1000000009;
    
    for (int i = 0; i < n; i++) {
        for (int l = 1; l <= n - i; l++) {
            int prefixScore = 0;
            int suffixScore = 0;
            long hashText = 0;
            long hashSuf = 0;
            long hashPre = 0;
            long p1 = 1;

            for (int j = i + l - 1; j >= i; j--) {
                int sufInd = i + l - j - 1;
                if (sufInd >= n2) {
                    break;
                }
                hashText = (hashText + (text.charAt(j) - 'a') * p1) % mod;
                p1 *= p;
                hashSuf = (hashSuf * p + (suffixString.charAt(sufInd) - 'a')) % mod;
                
                if (hashSuf == hashText) {
                    suffixScore = i + l - j;
                }
            }

            hashText = 0;
            p1 = 1;

            for (int j = i; j < i + l; j++) {
                int preInd = n1 + i - j - 1;
                if (preInd < 0) {
                    break;
                }
                hashText = (hashText + (text.charAt(j) - 'a') * p1) % mod;
                p1 *= p;
                hashPre = (hashPre * p + (prefixString.charAt(preInd) - 'a')) % mod;

                if (hashPre == hashText) {
                    prefixScore = j - i + 1;
                }
            }

            if (textScore < prefixScore + suffixScore) {
                textScore = prefixScore + suffixScore;
                ans = text.substring(i, i + l);
            } else if (textScore == prefixScore + suffixScore) {
                ans = ans.compareTo(text.substring(i, i + l)) > 0 ? text.substring(i, i + l) : ans;
            }
        }
    }

    return ans;
}
