class Solution {
    public int concatenatedBinary(int n) {
        
        int modulo = 1000000007;
        
        int newNo = 0;
        
        for(int i=1;i<= n;i++){
            String stringbinary = Integer.toBinaryString(i);
            for(char ch: stringbinary.toCharArray()){
                int val = (ch == '0'?0:1);
                newNo = ((newNo*2)%modulo+val)%modulo;
            }
        }
        
        
        return newNo;
            
    }
}