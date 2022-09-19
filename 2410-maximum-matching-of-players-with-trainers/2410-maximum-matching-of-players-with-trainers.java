class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        int count = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int j = 0;
        for(int i=0;i<players.length;){
            while(i<players.length && j<trainers.length){
                if(players[i] <= trainers[j]){
                    count++;
                    i++;
                }
                
                j++;
            }
            i++;
        }
        
        return count;
        
    }
}