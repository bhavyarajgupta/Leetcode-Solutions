class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b+a).compareTo(a+b));
        
        for (int num : nums) pq.add(Integer.toString(num));
        
        if (pq.peek().equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll());
        
        return sb.toString();
    }
}