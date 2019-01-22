package stack;
import java.util.*;

public class QueueUsingStack {
	
	private static Stack<Integer> inStack;
	private static Stack<Integer> outStack;
	
	
	public void enqueue(int item) {
		   inStack.push(item);
	}
     
	public int dequeue() throws NoSuchMethodException {
		if(outStack.isEmpty() && !inStack.isEmpty()) {
			while(!inStack.isEmpty()) {
			outStack.push(inStack.pop());
		    }
			
			if(outStack.isEmpty() && inStack.isEmpty()) {
				throw new NoSuchMethodException("can't perform dequeue operation");
			}
		}
		return outStack.pop();
	}
	
	public static void main(String[] args) throws NoSuchMethodException {
		// TODO Auto-generated method stub
     inStack = new Stack<Integer>();
     outStack = new Stack<Integer>();
     
     QueueUsingStack queue = new QueueUsingStack();
     queue.enqueue(0);
     queue.enqueue(2);	
 
	 System.out.println(queue.dequeue());
	
	 queue.enqueue(3);
	 
	 System.out.println(queue.dequeue());
	 System.out.println(queue.dequeue());
	}

}
