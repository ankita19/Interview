package array_string;
import java.util.HashSet;

public class ThreeSumToZero {

	public static void main(String[] args) {
		
		int[] num = {1,2,-3,6,8,-8};
		
		//sumToZero(num);
		
		sumToZeroSorting(new int[]{-1,-7,0,1,3,4});
		

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
	
	public static void sumToZeroSorting(int[] num) {
		
	for(int i = 0;i < num.length;i++) {
		int r = num.length -1;
		int s = i+1;
		
			while(s<r) {
				if(num[i]+num[s]+num[r] == 0) {
					System.out.println(num[i]+ " , "+num[s]+" , "+num[r]);
					r--;
					s++;
				}else  if(num[i]+num[s]+num[r] < 0)
					s++;
				else
					r--;
			}
		} 
	}
}
