class Solution {
    
    // TC --- > O(N * (N-M)) // SC --- > O(N * (N-M))
    public int[] movesToStamp(String stamp, String target) {
        
        char[] tchar = target.toCharArray();
        char[] schar = stamp.toCharArray();
        
        int count = 0;
        
        boolean vis[] = new boolean[tchar.length]; 
        
        List<Integer> res = new ArrayList<>();
        
        while(count != tchar.length){
            
            boolean didchanged = false;
            
            for(int i=0;i<=tchar.length - schar.length;i++){
                if(!vis[i] && canRaplce(tchar,i,schar)){
                    count  = replace(tchar,i,schar.length,count);
                    vis[i] = true;
                    didchanged = true;
                    res.add(i);
                    if(count == tchar.length){
                        break;
                    }
                    
                }
            }
            
            if(!didchanged) return new int[0];
        }
        
        int result[] = new int [res.size()];
        int k=0;
        for(int i = res.size()-1  ; i >= 0 ;i--)       //we need to reverse and store the list int to array
            result[k++] = res.get(i); 
        // System.out.println(result + " " +res);
        
        return result;
    }
    
    public boolean canRaplce(char [] tchar,int pos,char schar[]){
        for(int i=0;i<schar.length;i++){
            if(tchar[i+pos] != '?' && tchar[i+pos] != schar[i]){
                return false;
            }
        }
        
        return true;
    }
    
    public int replace(char [] tchar,int pos,int slength,int count){
        for(int i=0;i<slength;i++){
            if(tchar[i+pos] != '?'){
                tchar[i+pos] = '?';
                count++;
            }
        }
        
        return count;
    }
}