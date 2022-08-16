class Solution {
    
    // TC -> 2^t + k (exponential)
    
    public void recursive(int idx , int target,int[] a,List<List<Integer>> ans , List<Integer> ds){
        
        if(idx == a.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
                return;
            }else{
                return;
            }
        }
        
        if(a[idx] <= target){   //stops the excessive recursive call
            
            ds.add(a[idx]);
            recursive(idx,target-a[idx],a,ans,ds); //recursive call to picked element 
            ds.remove(ds.size()-1);           // remove last element which was added
        }
        
        
        
        recursive(idx+1,target,a,ans,ds);      // recursive call to non pick element (right)
    
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        recursive(0,target,candidates,ans,new ArrayList<>());
        
        return ans;
        
    }
}