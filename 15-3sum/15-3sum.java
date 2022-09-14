class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
       
        // HashSet<List<Integer>> set = new HashSet<>();
        
        List<List<Integer>> ans = new ArrayList<>(); 
        
        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            
            
            if(i>0 && nums[i] == nums[i-1]) continue;
            
            while(left<right){
                
                if(left == right || right == i || left == i) continue; 
                
                if(nums[left]+nums[right]+nums[i] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    temp.add(nums[i]); 
                    ans.add(temp);
                    
                    right--;
                    while(left<right && nums[right] == nums[right+1]){
                        right--;
                    }
                }
                
                if(nums[left]+nums[right]+nums[i] > 0 ) right--;
                else left++;
            }
            
            
            
        }
        
        // List<List<Integer>> ans = new ArrayList<>(set); 
        
        return ans;
        
    }
}