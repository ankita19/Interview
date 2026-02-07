package stack;

import java.util.LinkedList;
import java.util.Queue;

/*pop - O(n)
 * push - O(1)
 * 
 * */

public class StackUsingQueue {
	
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	int top;
	
	 /** Initialize your data structure here. */
    public StackUsingQueue() {
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	top = x;
    	q1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. 
     * @throws Exception */
    //O(n)
    public int pop() throws Exception {
    	
    	if(empty()) throw new Exception("Stack Empty. Invalid operation!!!");
    	
    	while(q1.size() > 1) {
    		q2.add(q1.remove());
    	}
    	int topEle = q1.remove();
    	Queue<Integer> tmp = new LinkedList<Integer>();
    	tmp = q1;
    	q1=q2;
    	q2=tmp;
    	
       //resetting top element and assumption is to not have Integer.Max_VALUE in stack. 
    	top = Integer.MAX_VALUE;
    return topEle;
       }
    
    /** Get the top element. */
    public int top() {
    	if(top == Integer.MAX_VALUE)
        return q1.peek();
    	else
    		return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.size() == 0 &&  q2.size() == 0)
        	return true;
        else return false;
    }
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		StackUsingQueue stack = new StackUsingQueue();
		
		stack.push(1);
		stack.push(2);

	//	System.out.println(stack.pop());
		
		
		System.out.println(stack.top());
		
	//	stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.top());
	}

}
