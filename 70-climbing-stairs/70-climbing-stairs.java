class Solution {
    //space optimised --> TC O(N) and SC(1)
    public int climbStairs(int n) {
        if(n<3)return n;
        int a=1;
        int b=2;
        for(int i=3;i<n;i++){
            int t=a+b;
            a=b;
            b=t;
        }
        return a+b;
    }
}