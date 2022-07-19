class Solution {
 
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int[][] arr = new int[numRows][numRows]; 
  

        for (int line = 0; line < numRows; line++)
        {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= line; i++)
            {
                if (line == i || i == 0)
                    arr[line][i] = 1;
                else 
                    arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
                temp.add(arr[line][i]);
                }
                ans.add(temp);
        }
        
        return ans;
    }
}