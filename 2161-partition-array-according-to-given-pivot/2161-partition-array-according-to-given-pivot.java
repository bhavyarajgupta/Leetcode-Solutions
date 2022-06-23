class Solution {
          
    public int[] pivotArray(int[] nums, int pivot) {
        
        Queue<Integer> smaller = new LinkedList<>();
        Queue<Integer> greater = new LinkedList<>();
        int count = 0;

        int res[] = new int[nums.length];
        for(int i : nums){
            if(i < pivot){
                smaller.add(i);
            }
            else if(i > pivot){
                greater.add(i);
            }
            else{
                count++;
            }
        }

        int j = 0;
        for(int i : smaller){
            res[j++] = i;
        }

        for(int i = 0; i < count; i++){
            res[j++] = pivot;
        }

        for(int i : greater){
            res[j++] = i;
        }

        return res;
    }
}