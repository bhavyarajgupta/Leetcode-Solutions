class Solution {
    private String refine(String exp) {
        StringBuilder refined = new StringBuilder("");
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if(c == ' ') continue;
            if(c == '+') {
                if(refined.length() == 0 || refined.charAt(refined.length()-1) == '(' )
                    refined.append( "0+");
                else if(refined.charAt(refined.length()-1) == '+' || refined.charAt(refined.length()-1) == '-')
                    continue;
                else
                    refined .append( c);
            } else if(c == '-') {
                if(refined.length() == 0 || refined.charAt(refined.length()-1) == '(' )
                    refined.append( "0-");
                else if(refined.charAt(refined.length()-1) == '+')
                    refined.setCharAt(refined.length()-1,'-') ;
                else if(refined.charAt(refined.length()-1) == '-')
                    refined.setCharAt(refined.length()-1,'+') ;
                else
                    refined.append(c);
            } else
                    refined.append(c);

        }

        return refined.toString();
    }
        
    public int calculate(String s) {
        s = refine(s);
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
                        
            if(ch == ' ') continue;
            else if(ch >= '0' && ch <='9' ){
                int num = 0;
                while(i < s.length() && ch >= '0' && ch <='9' ){
                    num = num*10+(ch - '0');
                    i++;
                    if(i < s.length())
                        ch = s.charAt(i);
                }
                
                i--;
                operand.push(num);
            }
            else if(ch == '('){
                operator.push(ch);
            }else if(ch == ')'){
                while(operator.peek() != '('){
                    int a = operand.pop();
                    int b = operand.pop();
                    char op = operator.pop();
                    
                    if(op == '+'){
                        operand.push(a+b);
                    }else{
                        operand.push(b-a);
                    }
                }
                
                operator.pop();
            }else{
                while(operator.size()>0 && operator.peek()!= '('){
                    int a = operand.pop();
                    int b = operand.pop();
                    char op = operator.pop();
                    
                    if(op == '+'){
                        operand.push(a+b);
                    }else{
                        operand.push(b-a);
                    }
                    
                } 
                
                operator.push(ch);
            }
                        
        }
         
        while(operator.size() > 0){
            int a = operand.pop();
            int b = operand.pop();
            char op = operator.pop();

            if(op == '+'){
                operand.push(a+b);
            }else{
                operand.push(b-a);
            }
        }
        
        return operand.pop();
        
    }
}