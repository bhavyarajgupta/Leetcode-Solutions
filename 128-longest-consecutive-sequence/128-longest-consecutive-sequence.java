class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
   
        
     HashMap<Integer,Boolean>  isStarting = new HashMap<>();
        
        
        for(int i=0;i<nums.length;i++){
            //Take all potential starting sequence
            isStarting.put(nums[i],true);
        }
        
        
       
        for(int i=0;i<nums.length;i++){
             //Remove Elements which cannot start a new Sequence
            if(isStarting.containsKey(nums[i]-1)){
                isStarting.put(nums[i],false);
            }
        }
        
        int max =0;
        
        for(int start:isStarting.keySet()){
            
            if(isStarting.get(start) == true){
            int curr =1;
            for(int end = start+1;isStarting.containsKey(end) == true;end++){
                curr++;
            }
            
            max =  Math.max(max ,curr);
                
            }
            
        }
        
        return max;
    }
}