class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        
        if(changed.length % 2 != 0 || changed.length < 2) return new int[0];
        
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<changed.length;i++){
            if(changed[i] == 0) continue;
            else map.put(changed[i],map.getOrDefault(changed[i],0)+1);
        }
        
        int[] ans = new int[changed.length/2];
        int count = 0;
        
        for(int i=0;i<changed.length;i++){
            
            if(changed[i] == 0 && changed[i+1] == 0 && (i+1 < changed.length)){
                ans[count] = changed[i];
                i++;
                count++;
            }
            
            // System.out.println(changed[i] + " , "+changed[i] * 2+" , "+map.getOrDefault(changed[i] * 2,0));
            if(map.getOrDefault(changed[i],0) >=1 && map.getOrDefault(changed[i] * 2,0) >= 1 && changed[i] != 0){
                ans[count] = changed[i];
                map.put(changed[i],map.get(changed[i])-1);
                map.put(changed[i]*2,map.get(changed[i]*2)-1);
                count++;
            }
            
            if(count == changed.length/2) break;
        }
        
        return count == changed.length/2? ans: new int[0];
        
        // return ans;
        
    }
}