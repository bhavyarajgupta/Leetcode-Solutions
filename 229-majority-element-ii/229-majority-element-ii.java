class Solution {
    public List<Integer> majorityElement(int[] nums) {
         
        List<Integer> list = new ArrayList<Integer>();  
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        for(int x:map.keySet()){
            if(map.get(x) > nums.length/3){
                list.add(x);
            }
        }
        return list;
    }
}