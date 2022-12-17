class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("/")||tokens[i].equals("*")){
                int one = stk.pop();
                int two = stk.pop();
                if(tokens[i].equals("+")){
                    stk.push(one + two);
                }else if(tokens[i].equals("-")){
                    // int one = stk.pop();
                    // int two = stk.pop();
                    stk.push(two - one);
                }if(tokens[i].equals("/")){
                    // int one = stk.pop();
                    // int two = stk.pop();
                    stk.push(two / one);
                }if(tokens[i].equals("*")){
                    // int one = stk.pop();
                    // int two = stk.pop();
                    stk.push(one * two);
                }
                
            }else{
                stk.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return stk.pop();
        
    }
}