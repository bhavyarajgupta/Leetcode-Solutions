class Solution {
    
    public static int radixSort(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
    }
    
    int result = 0;
    
    for (int exp = 1; max / exp > 0; exp *= 10){
        result = countSort(arr,exp);
    }
        
    return result;
        // return 0;
        
    // for(int j=0;j<res.length;j++){
    //     System.out.println(res[j]);
    // }    
     }
    
    public static int countSort(int[] arr, int exp) {
    int[] ans = new int[arr.length];
   
    int[] farr = new int[10];
    for (int i = 0; i < arr.length; i++) {
      farr[(arr[i]/exp) % 10]++;
    }
    
    for (int i = 1; i < farr.length; i++) {
      farr[i] += farr[i - 1];
    }
    
    for (int i = arr.length - 1; i >= 0; i--) {
      int pos = farr[(arr[i]/exp) % 10] - 1;
      ans[pos] = arr[i];
      farr[(arr[i]/exp) % 10]--;
    }
    
    // System.out.println(Arrays.toString(ans));    
    int max = Integer.MIN_VALUE;
    
    for (int i = 0; i < arr.length; i++) {
        // System.out.println("from loop ans "+ans[i]);
        // int diff = ans[i] - ans[i-1];
        // diff = Math.abs()
        // max = Math.max(diff, max);
        arr[i] = ans[i];
    }
        for (int i = 1; i < arr.length; i++) {
        // System.out.println("from loop ans "+ans[i]);
        int diff = arr[i] - arr[i-1];
        max = Math.max(diff, max);
        
    }
    // System.out.println(Arrays.toString(arr));  
    // System.out.println(max);
    return max;
    }

    
    
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        
        return radixSort(nums);
              
        
        
    }
}