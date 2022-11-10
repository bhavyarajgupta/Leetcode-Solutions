class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        for(int i=1;i<sb.length();i++){
            if(i>=1 && sb.charAt(i) == sb.charAt(i-1)){
                sb.delete(i-1,i+1);
                i-=2;
                // System.out.println(sb.toString() + " " + i);
            }
            
        }
        
        return sb.toString();
    }
}