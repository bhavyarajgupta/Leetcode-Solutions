class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
         Arrays.sort(nums);
               
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            
            if(i>0 && nums[i] == nums[i-1]) continue;
            
            while(left<right){
                
                if(left != right || right != i || left != i){
                    int temp = nums[left]+nums[right]+nums[i];
                
                    if( Math.abs(target-temp) <= diff){

                        ans = temp;
                        diff= Math.abs(target-temp);
                    }

                    if(nums[left]+nums[right]+nums[i] > target ) right--;
                    else left++;
                    
                }
               
            }
     
        }

        
        return ans;
        
        
        
    }
}