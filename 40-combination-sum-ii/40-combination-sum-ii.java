class Solution {
    
    public void recurssion(int idx,int target,int [] a,List<List<Integer>> ans,List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return ;
        }
        
        for(int i=idx;i<a.length;i++){
            if(i > idx && a[i] == a[i-1]) continue;       //skiping duplicates element if it is takken once
            if(a[i] > target) break;
            
            ds.add(a[i]);
            recurssion(i+1,target-a[i],a,ans,ds);
            ds.remove(ds.size()-1);
        }
        
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        recurssion(0,target,candidates,ans,new ArrayList<>());
        return ans;
        
    }
}