class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n>m){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        int k = (n+m)/2;
        int lo = Math.max(0,k-m);
        int high = Math.min(k,n);
        
        while(lo<= high){
            int cut1 = lo+(high-lo)/2;
            int cut2 = k-cut1;
            
            int l1 = cut1 == 0?Integer.MIN_VALUE:nums1[cut1-1];
            int l2 = cut2 == 0?Integer.MIN_VALUE:nums2[cut2-1];
            
            int r1 = cut1 == n?Integer.MAX_VALUE:nums1[cut1];        
            int r2 = cut2 == m?Integer.MAX_VALUE:nums2[cut2];
            
            if(l1 <= r2 && l2 <= r1 ){
                if((n+m)%2 == 0){
                    return (double)(Math.max(l1,l2) + Math.min(r1,r2))/2;
                }else{
                    return (double)(Math.min(r1,r2));
                }
            }else if(l1 > r2){
                high = cut1-1;   
            }else{
                lo =  cut1+1;
            }
        }
        
        return -1;
    }
}