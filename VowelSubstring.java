package com.cg.havherrank;

class Result {
    public static long vowelsubstring(String s) {
        long[] lstpos = new long[26];
        for (int i = 0; i < 26; i++) {
            lstpos[i] = -1;
        }
        long n = s.length();
        long ans = 0;
        long mxVal = -1000000000000000000L; // Corrected initialization
        long mnVal = 1000000000000000000L;  // Corrected initialization

        for (int i = 0; i < n; i++) {
            lstpos[s.charAt(i) - 'a'] = i;
            long vw = 1000000000L; // Corrected initialization
            long cs = -1;

            for (int j = 0; j < 26; j++) {
                if (j == 'a' - 'a' || j == 'e' - 'a' || j == 'i' - 'a' || j == 'o' - 'a' || j == 'u' - 'a') {
                    vw = Math.min(vw, lstpos[j]);
                } else {
                    cs = Math.max(cs, lstpos[j]);
                }
            }
            ans += Math.max(0, vw - cs);
            mnVal = Math.min(mnVal, ans);
            mxVal = Math.max(mxVal, ans);
        }
        return ans;
    }
}
