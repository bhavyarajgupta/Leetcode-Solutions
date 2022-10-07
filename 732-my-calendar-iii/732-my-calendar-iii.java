class MyCalendarThree {

    private TreeMap<Integer,Integer> tmap;
    
    public MyCalendarThree() {
        tmap = new TreeMap<>();    
    }
        
    public int book(int start, int end) {
        tmap.put(start,tmap.getOrDefault(start,0)+1);    
        tmap.put(end,tmap.getOrDefault(end,0)-1);
        
        int activeBooking =0;
        int maxactive = 0;
        for(int event: tmap.values()){
            activeBooking += event;
            maxactive = Math.max(maxactive,activeBooking);
        }
        
        return maxactive;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */