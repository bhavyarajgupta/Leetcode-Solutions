class Solution {
    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int val : data) {
            if (count == 0) {
                if (val >> 3 == 0b11110) {
                    count = 3;
                } else if (val >> 4 == 0b1110) {
                    count = 2;
                } else if (val >> 5 == 0b110) {
                    count = 1;
                } else if (val >> 7 == 0b0) {
                    count = 0;
                } else {
                    return false;
                }
            } else {
                if (val >> 6 == 0b10) {
                    count--;
                } else {
                    return false;
                }
            }
        }
        return count == 0;
    }
}