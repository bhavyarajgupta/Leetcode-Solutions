class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        if(word1.length()!=word2.length()) return false;

        int[] freqWord1 = new int[26];
        int[] freqWord2 = new int[26];

        for(int i=0; i<word1.length(); i++){
            freqWord1[word1.charAt(i)-'a']++;
        }
        for(int i=0; i<word2.length(); i++){
            freqWord2[word2.charAt(i)-'a']++;
        }

        int count1=0, count2=0;
        for(int i=0; i<26; i++){
            if(freqWord1[i]>0) count1++;
            if(freqWord2[i]>0) count2++;
        }

        boolean check1=true;
        for(int i=0; i<26; i++){
            if((freqWord1[i]>0 && freqWord2[i]==0) || (freqWord1[i]==0 && freqWord2[i]>0)){
                check1=false;
                break;
            }
        }

        Arrays.sort(freqWord1);
        Arrays.sort(freqWord2);

        boolean check2=true;
        for(int i=0; i<26; i++){
            if(freqWord1[i]!=freqWord2[i]){
                check2=false;
                break;
            }
        }
        return count1==count2 && check1 && check2;
    }
}