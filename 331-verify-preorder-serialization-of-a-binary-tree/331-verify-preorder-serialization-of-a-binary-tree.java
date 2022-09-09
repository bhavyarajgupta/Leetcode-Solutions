class Solution {
    public boolean isValidSerialization(String preorder) {
        String [] pre = preorder.split(",");
        int v = 1;
        
        for(int i=0;i<pre.length;i++){
            
            v--;
            
            if(v<0) return false;
            
            if(!pre[i].equals("#")) v +=2;
        }
        
        return v==0;
        
    }
}