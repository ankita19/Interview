
import java.util.*;
import java.lang.*;

class RexTester
{  
    static List<String> precedence;
    
    public static void main(String args[]) throws Exception {
        precedence = new ArrayList<String>();
        
        precedence.add("+");
        precedence.add("*");
        precedence.add("J");
     
        
        String expr = "2 + 4 J 2";
        System.out.println(expr + " = " + evaluate(expr));
    }
    
    private static int evaluate(String expr) throws Exception {
        Stack<Character> opStack = new Stack<Character>();
        Stack<Integer> valueStack = new Stack<Integer>();
        
        char[] tokens = expr.toCharArray();
        
        for(Character c : tokens) {
            if(c == ' ')
                continue;
            
            if(c >= '0' && c <= '9') {   // digit
                valueStack.push(Integer.parseInt(c.toString()));
            } else {                     // operator
                while(!opStack.isEmpty() && hasprecedence(c, opStack.peek())) {
                    valueStack.push(getValue(valueStack.pop(), valueStack.pop(), opStack.pop()));
                }
                
                opStack.push(c);
            }
            
            //System.out.println(valueStack);
        }
        
        while(!opStack.isEmpty()) {
            valueStack.push(getValue(valueStack.pop(), valueStack.pop(), opStack.pop()));
            //System.out.println("ok: " + valueStack);
        } 
        
        // Last value in valueStack is final answer
        if(!valueStack.isEmpty())
            return valueStack.pop();
        return 0;
    }
    
    /**
        Check if op2 has higher precedence than op1
    */
    private static boolean hasprecedence(char op1, char op2) {
        return precedence.indexOf(op2) >= precedence.indexOf(op1);
    }
                   
    private static int getValue(int val1, int val2, char op) throws Exception {
        int result = 0;
        
        switch(op) {
            case '+':
                result = val1 + val2;
                break;
            case 'J':
                result = val2*10+val1;
                break;
            case '*':
                result = val1 * val2;
                break;
            case '/':
                if(val1 == 0) {
                    throw new Exception("divide by zero");
                }
                result = val2 / val1;
        }
        
        return result;
    }
}