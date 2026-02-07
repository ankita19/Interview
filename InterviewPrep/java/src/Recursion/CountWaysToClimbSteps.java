package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountWaysToClimbSteps {
	
	public static void countPaths(int n,int[] a,List<Integer> list) {
		
		if(n==0)
		{
			list.forEach(x->System.out.print(x+ ","));
			System.out.println();
			return;
		}else if(n < 0) {
			return;
		}
		
		for(int i = 0 ; i< a.length ;i++) {
		
				list.add(a[i]);
				countPaths(n-a[i] ,a,list);
				
				//System.out.println("index-"+i);
				//list.forEach(x->System.out.print(x+ ","));
				list.remove(list.size()-1);
		
		}
		
	}

public static int countWays(int n,int[] a) {
	if(n==0)
		{
			return 1;
		}else if(n < 0) {
			return 0;
		}
		int count =0;
		for(int i = 0 ; i< a.length ;i++) {
				count += countWays(n-a[i] ,a);
		
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countWays(4, new int[] {1, 2}));
		countPaths(3, new int[] {1, 2}, new ArrayList<Integer>());
		
	}

}
