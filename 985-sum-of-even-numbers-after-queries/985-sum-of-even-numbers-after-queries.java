class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int ans[] = new int[nums.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        int evensum = 0;
        
        for(int i=0;i<nums.length;i++){
            map.put(i,nums[i]);
            if(nums[i] % 2 == 0) evensum += nums[i];
        }
        
        for(int i=0;i<queries.length;i++){
            int val = queries[i][0];
            int idx = queries[i][1];
            
            int temp = map.get(idx);
            map.put(idx,temp+val);
            
            if(map.get(idx)%2 == 0){
                if(temp % 2 == 0) evensum -= temp;
                evensum += map.get(idx);
            }else{
                if(temp % 2 == 0) evensum -= temp;
            }
            // System.out.println(temp +"  "+map.get(idx)+ "  Sum is " + evensum);
            
            ans[i] = evensum;
        }
        
        return ans;
    }
}