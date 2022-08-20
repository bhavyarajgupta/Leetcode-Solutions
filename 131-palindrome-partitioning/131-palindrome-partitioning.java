class Solution {
    public List<List<String>> partition(String s) {
     
        List<List<String>> res = new ArrayList<>();
        
        partitioner(s,res,new ArrayList<>(),0);
        
        return res;
    }
    
    void partitioner(String s,List<List<String>> res,List<String> path,int idx){
        if(idx == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=idx;i<s.length();++i){
            
            if(isPalindrome(s,idx,i)){
                path.add(s.substring(idx,i+1));
                
                partitioner(s,res,path,i+1);
                
                path.remove(path.size() - 1);
            }
        }
    }
    
    boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}