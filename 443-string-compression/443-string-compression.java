class Solution {
    public int compress(char[] chars) {
        // StringBuilder s = new StringBuilder("");
        String s="";
        
        // s.append(chars[0]);
        s+=chars[0];
        int count =1;
        for(int i = 1;i<chars.length;i++){
            
            if(s.charAt(s.length()-1) == chars[i]){
                count++;
            }else if(count > 1 && s.charAt(s.length()-1) != chars[i]){
                // s.append(count);
                s+=count;
                // s.append(chars[i]);
                s+=chars[i];
                count = 1;
            }else{
                // s.append(chars[i]);
                s+=chars[i];
                count = 1;
            }
            
        }
        
        if(count>1){
            s+=count;
        }
        
        for(int i=0;i<s.length();i++){
            chars[i]=s.charAt(i); 
        }
        
        // int len = s.length();
        // System.out.println(s);
        return s.length();
    }
}