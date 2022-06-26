class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        for(int x:map.keySet()){
            if(map.get(x) > nums.length/2){
                return x;
            }
        }
        return -1;
 
    }
}