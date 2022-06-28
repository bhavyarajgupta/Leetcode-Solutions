class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words[0].length();
        int wordlen = len * words.length;
        
        List<Integer> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        
        
        for(String st:words){
            map.put(st,map.getOrDefault(st,0)+1);
        }
        
        for(int i=0;i<s.length()-wordlen+1;i++){
            String check = s.substring(i,i+wordlen);
            // int store = i+wordlen;
            // System.out.println(i + " " + store +" "+check);
            // int count = 0;
            
            HashMap<String,Integer> temp = new HashMap<>();
            // System.out.println(check.length());
            for(int j=0;j<check.length()-len+1;j=j+len){
                if(map.containsKey(check.substring(j,j+len))){  
                                    // System.out.println(check.substring(j,j+len));
                    temp.put(check.substring(j,j+len),temp.getOrDefault(check.substring(j,j+len),0)+1);  
        
                                                             
                }
              
            }
            // temp.putAll(map);
            // System.out.println(i + "  " + temp.size() +"  "+ map.size());
            
           
         
            // for(String st: map.keySet()){
//             for(String st:words){
//                 System.out.println(i);
//                 if(map.get(st) > 0 && check.contains(st) ) {
//                     System.out.println(map + st);
//                     map.put(st,map.get(st)-1);
//                     count++;                    
                    
//                 }
                
//             }
            
            // map.putAll(temp);
            
            // if(count == words.length){
            if(temp.equals(map)){
                 
                // System.out.println("lastcount "+ count);
                res.add(i);
            }
            
            temp.clear();
        }
        
        return res;
        
    }
}