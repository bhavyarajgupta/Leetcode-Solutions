
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] lis = new int[nums.length];
        int[] hash = new int[nums.length];
        Arrays.fill(hash, -1);
        Arrays.sort(nums);
        int maxIdx = 0;
        for(int i=1; i<nums.length; ++i){
            for(int j=0; j<i; ++j){
                if(nums[i]%nums[j] == 0 && lis[j]+1 > lis[i]){
                    lis[i] = lis[j]+1;
                    hash[i] = j;
                    if(lis[maxIdx] < lis[i])
                        maxIdx = i;
                }
            }
        }
        
        return buildSeq(nums, hash, maxIdx);
    }
    
    public List<Integer> buildSeq(int[] nums, int[] lis, int idx){
        List<Integer> seq = new ArrayList<>();
        while(idx >=0){
            seq.add(nums[idx]);
            idx = lis[idx];
        }
        return seq;
    }
}