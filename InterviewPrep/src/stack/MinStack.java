package stack;

class MinStack {
    private int maxSize;
    private element[] stackArray;
    private int top;
    
    class element{
        int value;
        int  min;
        
      element(int val , int minVal){
          value = val;
          min = minVal;
      }  
    }
    
    /** initialize your data structure here. */
    public MinStack(int size) {    
        maxSize = size;
        stackArray = new element[maxSize];
        top = -1;
       }
    
    public void push(int x) {
       int index = ++top;
    	int min;  
    	
        if(index==0){
        	min= x;
        }
        else if(x < stackArray[top-1].min )
        	min = x;   
          else   
        	  min = stackArray[top-1].min;
        stackArray[index] = new element(x, min);
    }
    
    public int pop() {
        return stackArray[top--].value;
    }
    
    public int top() {
    	
        return stackArray[top].value;
    }
    
    public int getMin() {
        
        return stackArray[top].min;
    }
    
    public boolean isFull() {
    return (top == maxSize-1);	
    }
    
    public boolean isEmpty() {
    return (top== -1);
    }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

	public static void main(String[] args) {
		MinStack obj = new MinStack(10);
		  obj.push(1);
		  obj.push(2);
		  obj.push(0);
		  obj.pop();
		  int param_3 = obj.top();
		  int param_4 = obj.getMin();
		  
		  System.out.println(param_3);
		  System.out.println(param_4);

	}

}
