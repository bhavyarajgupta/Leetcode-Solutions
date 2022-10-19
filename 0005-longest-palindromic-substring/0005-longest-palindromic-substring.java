class Solution {
    public String longestPalindrome(String str) {
       boolean[][] dp = new boolean[str.length()][str.length()];
        int start = 0, end = 0;
        /**
         * The loop should be Diagonal wise Starting with gap = 0 till string length
         * First loop it should cover [(0,0), (1,1), (2,2), (3,3), (4,4)]
         * Second Loop - (0,1), (1,2), (2,3) & (3,4)
         *
         * Like this diagonally it should travel and solve the problem.
         */
        for (int gap = 0; gap < str.length(); gap++) {
            for (int i = 0, j = gap; j < dp[0].length; i++, j++) {

                /**
                 *    Case-1 : For Gap-0, i.e. position [(0,0), (1,1), (2,2)] values are always TRUE.
                 *             Because start and end position is same. So, it consists of one character only.
                 */
                if (gap == 0) {
                    dp[i][j] = true;
                    continue;
                }
                /**
                 *    Case-2 : For Gap-1, i.e. position (0,1), (1,2), (2,3) & (3,4) Compare the Start position and End position.
                 *             Because there are only two characters are there.
                 */
                if (gap == 1 && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = true;
                }
                /**
                 *  Case-3 : For all rest of the position check the start and end position
                 *           If true check for middle part of the string i.e. check for (start+1) till (End -1) position.
                 *           Which can be obtained from left diagonal value i.e. for (i,j) check for (i+1 , j -1)
                 */
                else if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
                    dp[i][j] = true;
                }

                /**
                 * Keeping track of the Start end End position of the Palindromic String.
                 * As Gap is increasing we are not doing any comparison with the previous range.
                 * With increasing of the Gap value if the substring is palindrome then it will be
                 * the bigger substring.
                 */
                if (dp[i][j]) {
                    start = i;
                    end = j;
                }

            }
        }

        return str.substring(start, end + 1);
    }

}