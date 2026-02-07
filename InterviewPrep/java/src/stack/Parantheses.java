package stack;

public class Parantheses {

	public class stack{
		char[] paran;
		int max;
		int top;

	public stack(int max) {
		paran = new char[max];
		top = -1;
	}
	
	public void push(char c) {
		paran[++top] = c;
	}
		
	public char pop() {
		System.out.println(top +":" +paran[top]) ;
		char c =  paran[top];
		top--;
		return c;
	}
	
	public boolean isEmpty() {
		if (top == -1) return true;
		else return false;
		
	}
	}
	
	
	public boolean validExpression(char[] exp) {
		
		stack arrayStack = new stack(10);
		int i = 0 ;
		int l = exp.length;
		while(i<l) {
			if(exp[i] == '{' || exp[i] == '(' || exp[i] == '['   ) {
					arrayStack.push(exp[i]);
				}
			
			if(exp[i] == '}' || exp[i] == ')' || exp[i] == ']'   ) {
				
				if(arrayStack.isEmpty()) return false;
				
				System.out.println(exp[i]);
				switch(exp[i]) {
				
				case '}' : if(arrayStack.pop() != '{' )
					       return false;
				           break;
				           
				case ')' : if(arrayStack.pop() != '(')
				       return false;break;
				case ']' : if(arrayStack.pop() != '[')
				       return false; break;
				 default : return false; 
				}
		}
			
		i++;	
			
		}
		
		if(arrayStack.isEmpty()) return true;
		
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] exp = {'{' ,'(', '}'};
		Parantheses obj = new  Parantheses();
		
		System.out.println(obj.validExpression(exp));
		
		
	}
	
	
	

}
