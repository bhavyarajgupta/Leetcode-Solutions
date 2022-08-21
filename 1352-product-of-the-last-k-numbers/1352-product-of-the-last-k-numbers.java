class ProductOfNumbers {
    
    ArrayList<Integer> store;
    public ProductOfNumbers() {
        store = new ArrayList<>();
    }
    
    public void add(int num) {
        store.add(num);
    }
    
    public int getProduct(int k) {
        int prod = 1;
        int len = store.size();
        int anslen = len - k;
        while(anslen < len){
            prod *= store.get(anslen);
            anslen++;
        }
        
        return prod;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */