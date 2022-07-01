class Solution {
    
    class Getmax implements Comparator<int[]> {
        
        public int compare(int[] a, int[] b){
            return b[1] - a[1];            
        }
        
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes,new Getmax());
        
        int res =0 ;
        for(int[] item: boxTypes){
            
            if(item[0] < truckSize){
                res += item[0]*item[1];
            }else{
                res += truckSize*item[1];
                break;
            }
            
            truckSize -= item[0];
        }
            
        
        
        
        return res;
    }
}