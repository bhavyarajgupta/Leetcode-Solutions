class Solution {
    
    int gcd(int x, int y){
        if(y == 0)
            return x;
        return gcd(y, x % y);
    }
    
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if((jug1Capacity + jug2Capacity) < targetCapacity) return false;
                
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }
}


