package stack;


import java.util.Arrays;

import java.util.Stack;

/*
Problem
==============



=============
Example
============


==============
Solution
============

Optimal
Time Complexity : O(n)
Space complexity : O(1)
*/
public class MinStack3 {
	
	 int min = Integer.MAX_VALUE;
	    Stack<Integer> stack = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack3() {
       
    }
    
   
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","]
	//			[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
		MinStack3 obj = new MinStack3();
		
		obj.push(2147483646);
		obj.push(2147483646);
		obj.push(2147483647);
	//	System.out.println(obj.stack.size());
		System.out.println(obj.top());
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		obj.push(2147483647);
		System.out.println(obj.top());
		System.out.println(obj.getMin());
		obj.push(-2147483648);
		
		System.out.println(obj.stack.size());
		
		System.out.println(obj.top());
		System.out.println(obj.getMin());
		
		System.out.println(Arrays.toString(obj.stack.toArray()));
		
		obj.pop();
		System.out.println(obj.stack.size());
		System.out.println(obj.getMin());
		obj.pop();
		
	}

}
