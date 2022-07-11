// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    static StringBuilder topo = new StringBuilder();
    public static void DFS(char ch,HashMap<Character,ArrayList<Character>> adj,HashMap<Character,Boolean> vis){
        if(vis.getOrDefault(ch,false) == true) return ;
        
        vis.put(ch,true);
        for(char cc:adj.get(ch)){
            DFS(cc,adj,vis);
        }
        
        topo.append(ch);
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        HashMap<Character,ArrayList<Character>> adj = new HashMap<>(); 
        
        
        for(int i=0;i<N-1;i++){
            String a = dict[i],b = dict[i+1];
            int j =0;
            while(j<a.length() && j<b.length()){
             if(a.charAt(j) != b.charAt(j)){
                 if(adj.containsKey(a.charAt(j)) == false){
                     adj.put(a.charAt(j) , new ArrayList<>());
                 }
                 
                 if(adj.containsKey(b.charAt(j)) == false){
                     adj.put(b.charAt(j) , new ArrayList<>());
                 }
                 
                 adj.get(a.charAt(j)).add(b.charAt(j));   //fill second element from b in empty list
                 break;
             }
             
             j++;
            }
        }
        
        HashMap<Character,Boolean> vis = new HashMap<>();
        
        for(char key:adj.keySet()){
            DFS(key,adj,vis);
        }
        
        return topo.reverse().toString();
    }
}