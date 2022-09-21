class Solution {
    
    private long factorial(long n)
    {
        long res = 1;

        // Calculate value of
        // [1*(2)*---*(n-k+1)] /
        // [k*(k-1)*---*1]
        for (int i = 1; i <= n; ++i)
        {
            res *= i;
        }

        return res;
    }

    private long binomialCoeff(long n,
                            long k)
    {
        long res = 1;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k)
            k = n - k;

        // Calculate value of
        // [n*(n-1)*---*(n-k+1)] /
        // [k*(k-1)*---*1]
        for (int i = 0; i < k; ++i)
        {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }


    // A Binomial coefficient
    // based function to find
    // nth catalan number in
    // O(n) time
    private long catalan( long n)
    {

        // Calculate value of 2nCn
        long c = binomialCoeff(2 * n, n);

        // return 2nCn/(n+1)
        return c / (n + 1);
    }
    
    public int numTrees(int n) {
        return (int)catalan(n);
    }
}