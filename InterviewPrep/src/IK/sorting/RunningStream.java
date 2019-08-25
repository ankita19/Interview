package IK.sorting;

import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningStream {
	int k;
	PriorityQueue<Integer> runningStream;
	
	public RunningStream(int k) {
		this.k= k;
		this.runningStream = new PriorityQueue<>(k,(a,b) -> a-b);		
	}
	
	
	public  void process(int i,int k) {
		
		if(i == 404)
		{	System.out.println("Printing top  K");
			printStream(runningStream);
		}else 
			runningStream.add(i);
		
		
		if(runningStream.size() > k)
			runningStream.poll();
	}
	public  void findTopK(int[] input) {
	for(int i : input) {
		process(i,k);
	}
	}
	
	public void printStream(PriorityQueue<Integer> pq) {
		pq.forEach(x-> System.out.println(x));
	}
	
	public static void main(String[] args) {
		
		RunningStream rn = new RunningStream(2);
		
		rn.findTopK(new int[] {1,9,8,4,6,404,4,19,20,404});
		

	}

}
