class Solution {
    public boolean isUgly(int n) {
        
        while(n > 1){
            int temp = n;
            if(n%2 == 0){
                n /= 2;
            }
            if(n%3 == 0){
                n /= 3;
            }
            if(n%5 == 0){
                n /= 5;
            }
            
            if(n == temp){
                break;
            }
        }
        
        return n == 1? true : false;
    }
}