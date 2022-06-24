class FindSumPairs {
    int[] nums1, nums2;
    
    Map<Integer, Integer> map = new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        
        for(int x:nums2){
            map.put(x,map.getOrDefault(x,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int temp = nums2[index];
        int temp2 = temp+val;
        
        if(map.get(temp)>1){
            map.put(temp,map.get(temp)-1);
        }else{
            map.remove(temp);
        }
        
        map.put(temp2,map.getOrDefault(temp2,0)+1);
        nums2[index] = temp2;
        
    }
    
    public int count(int tot) {
        int cc =0;
        for(int x:nums1){
            if(map.containsKey(tot-x)){
                cc = cc + map.get(tot-x);
            }
        }
        return cc;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */