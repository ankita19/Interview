package array;
import java.util.HashSet;

public class ThreeSumToZero {

	public static void main(String[] args) {
		
		int[] num = {1,2,-3,6,8,-8};
		
		sumToZero(num);
		

	}

	public static void sumToZero(int[] num) {
		
		HashSet<Integer> compNum = new HashSet<Integer>();
		
		for(int i = 0 ; i< num.length-1 ; i++) {
			for(int j = 1 ; i< num.length ; i++) {
				
				if(compNum.contains(-(num[i] + num[j])) ) {
					System.out.println(num[i] +" : "+ num[j] + " : " + -(num[i]+num[j]));
					}
				else
					compNum.add(num[i]);
				
			}
		}
		
	}
	
	
}
