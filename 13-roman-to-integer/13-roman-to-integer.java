class Solution {
    public int romanToInt(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        
        int sum = 0;
        
        for(int i = s.length()-1 ; i>=0 ;i--){
            
            // if((s.charAt(i-1) == 'I' && s.charAt(i) == 'V') || (s.charAt(i-1) == 'I' && s.charAt(i) == 'V' ) ||
            //   (s.charAt(i-1) == 'X' && s.charAt(i) == 'L' ) || (s.charAt(i-1) == 'X' && s.charAt(i) == 'C' ) ||
            //   (s.charAt(i-1) == 'C' && s.charAt(i) == 'D' ) || (s.charAt(i-1) == 'C' && s.charAt(i) == 'M' ))
            // {
            //     sum +=  map.getOrDefault(s.charAt(i),0) - map.getOrDefault(s.charAt(i-1),0);
            //     i --;
            // }else{
            //     sum += map.getOrDefault(s.charAt(i),0);
            // }
            
            if( i > 0 && map.containsKey(""+s.charAt(i-1)+s.charAt(i))){
                sum += map.get(""+s.charAt(i-1) + s.charAt(i));
                // System.out.println(""+s.charAt(i) + s.charAt(i-1));
                i--;
            }else if(map.containsKey(s.charAt(i) + "" )){
                sum += map.get(s.charAt(i) + "");
            }
        }
        
        return sum;
    }
}