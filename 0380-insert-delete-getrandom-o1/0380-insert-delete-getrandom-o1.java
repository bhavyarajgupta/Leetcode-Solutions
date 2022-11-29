class RandomizedSet {
    
    ArrayList<Integer> forMap ;    
    
    Map<Integer,Integer> map;
    public RandomizedSet() {
        map = new HashMap<>();
        forMap = new ArrayList<>();   
    }
    
    public boolean insert(int val) {
        
       if(map.containsKey(val)){
           return false;
       }else{
           forMap.add(val);
           map.put(val,forMap.size()-1);
           return true;
       }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index =  map.remove(val);
            int idx = forMap.get(forMap.size()-1);
            map.put(idx,index);
            
            Collections.swap(forMap,index,forMap.size()-1);
            forMap.remove(forMap.size()-1);
            map.remove(val);
           return true;
       }else{
           
           return false;
       }
    }
    
    public int getRandom() {
        int idx = (int)(Math.random() * forMap.size());
        
        return forMap.get(idx);
    }
    
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */