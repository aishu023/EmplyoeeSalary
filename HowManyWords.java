
public static int howMany(String sentence) {
    int i = 0;
    int ans = 0;
    int n = sentence.length();
    // process all characters
    while (i < n) {
        int c = 0; // alphabetic character and dashes count
        int c2 = 0; // total character count
        int c3 = 0; // valid punctuation
        // update character type counts until a space is reached
        while (i < n && sentence.charAt(i) != ' ') {
            if ((sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z') || (sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'Z') || sentence.charAt(i) == '-') {
                c += 1;
            } else if (sentence.charAt(i) == ',' || sentence.charAt(i) == '.' || sentence.charAt(i) == '?' || sentence.charAt(i) == '!') {
                c3 += 1;
            }
            c2 += 1;
            i += 1;
        }
        // end of word - add to word count only if
        // valid characters count + valid punctuation count == all letters count
        // and some valid characters are present in the word
        if (c + c3 == c2 && c > 0) {
            ans += 1;
        }
        // skip all spaces
        while (i < n && sentence.charAt(i) == ' ') {
            i += 1;
        }
    }
    return ans;
}
