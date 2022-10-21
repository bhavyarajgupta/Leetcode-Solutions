class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        boolean negative = s.charAt(0) == '-'? true : false;
        int start = s.charAt(0) != '-' && s.charAt(0) != '+'? 0 : 1;
        
        long ans = 0;
        for(int i = start; i < s.length(); i++) {
            if(s.charAt(i) < '0' || s.charAt(i) > '9') break;

            ans = ans * 10 + (s.charAt(i) - '0');;
            
            if(-ans <= Integer.MIN_VALUE && negative) 
                return Integer.MIN_VALUE;
            
            if(ans >= Integer.MAX_VALUE && !negative) 
                return Integer.MAX_VALUE;
        }

        return (int)(negative? -ans : ans);
    }
}