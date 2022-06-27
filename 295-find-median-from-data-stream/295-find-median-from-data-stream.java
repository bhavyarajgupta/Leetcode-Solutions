class MedianFinder {
    
    PriorityQueue<Integer> leftMax,rightMin;
    public MedianFinder() {
        leftMax = new PriorityQueue<>(Collections.reverseOrder());
        rightMin = new PriorityQueue<>();

    }
    
    public void addNum(int num) {
        double median = findMedian(); // gives median at that point of call
        
        if(num <= median){
            leftMax.add(num);
        }else{
            rightMin.add(num);
        }
        
        if(leftMax.size() > rightMin.size()+1){
            rightMin.add(leftMax.remove());
        }else  if(leftMax.size()+1 < rightMin.size()){
            leftMax.add(rightMin.remove());
        }
        
    }
    
    public double findMedian() {
    
        if(leftMax.size()+rightMin.size() ==0) return -1;
        
        if(leftMax.size() == rightMin.size()){
            return (leftMax.peek() + rightMin.peek())/2.0;
        }else if(leftMax.size() == rightMin.size()+1){
            return leftMax.peek();
        }else{
            return rightMin.peek();
        }
    
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */