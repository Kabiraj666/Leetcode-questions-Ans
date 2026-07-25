class Solution {
public:
    string smallestSubsequence(string s) {
        vector<short> letters(26, 0);
        int usedLetters = 0;

        short i;
        short n = s.length();
        for(i = 0; i < n; ++i) {
            letters[s[i] - 'a'] = i;
        }

        short iSubsequence = -1;
        for(i = 0; i < n; ++i) {
            if((usedLetters & (1 << (s[i] - 'a'))) < 1) {
                while(iSubsequence > -1 && s[i] < s[iSubsequence] && letters[s[iSubsequence] - 'a'] > i) {
                    usedLetters ^= 1 << (s[iSubsequence--] - 'a');
                }

                s[++iSubsequence] = s[i];
                usedLetters |= 1 << (s[i] - 'a');
            }
        }

        s.resize(++iSubsequence);

        return s;
    }
};