package IK.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateSubset {
	
	public static void subset(int[] a){
		
		int[] s = new int[a.length];
		
		List<int[]> list = new ArrayList<int[]>();
		
		helper(a,s,0,0,list);
		
		list.forEach(x->System.out.println(Arrays.toString(x)));
		
		
	}

	public static void helper(int[] a , int[] s,int i,int j,List<int[]> list) {
		if(j==a.length)
			{list.add(Arrays.copyOfRange(s, 0, i));
			return;
			}
		else if(j < a.length) {
		s[i] = a[j];
		helper(a,s,i+1,j+1,list);
		//s[i] = null;
		helper(a,s,i,j+1,list);
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subset(new int[]{1,2,3});
	}

}
