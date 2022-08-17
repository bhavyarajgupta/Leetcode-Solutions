class Solution {
    
//     void recPerm(int[] nums,List<Integer> ds,List<List<Integer>> ans,boolean[] freq){
//         if(ds.size() == nums.length){
//             ans.add(new ArrayList<>(ds));
//             return;
//         }   
        
//         for(int i=0;i<nums.length;i++){
//             if(!freq[i]){
//                 freq[i] = true;
//                 ds.add(nums[i]);
//                 recPerm(nums,ds,ans,freq);
//                 ds.remove(ds.size()-1);
//                 freq[i] = false;
//             }
//         }
        
//     }
    
    void recPerm(int index,int[] nums,List<List<Integer>> ans){
        if(index == nums.length){
            //copy swapped array element to ds and then to ans
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            recPerm(index+1,nums,ans);
            swap(i,index,nums);
        }
    }
    
    void swap(int i,int j,int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        recPerm(0,nums,ans);
        // recPerm(nums,new ArrayList<>(),ans,freq);
        return ans;    
    }
    
    
}