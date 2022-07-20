class Solution {
public int numMatchingSubseq(String s, String[] words) {
HashMap<Character,Integer> map2 = new HashMap<>();
​
for(int i=0;i<s.length();i++){
// map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
map2.put(s.charAt(i),map2.getOrDefault(s.charAt(i),0)+1);
}
int count = 0;
for(int i=0;i<words.length;i++){
int len = 0;
HashMap<Character,Integer> map = new HashMap<>(map2);
boolean checker = false;
String str = words[i];
for(int j=0;j<str.length();j++){
char ch = str.charAt(j);
// System.out.println(ch + "  " +map);
if(map.containsKey(ch) && map.get(ch) > 0){
len++;
checker = true;
map.put(ch,map.getOrDefault(ch,0)-1);
}else{
checker = false;
}
}
if(checker == true && len == str.length()){
System.out.println(str);
count++;
}
// System.out.println(str+" "+checker);
​
// map.clear();
// map = map2;
}
return count;
}
}