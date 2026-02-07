package basics;
/*
 * 1) sort 2d array without creating object class
 * 
 * */

import java.util.*;
public class ArraysPrac {

	public int[][] sortArray(int[][] input){
		
		 Arrays.sort(input, (int[] object1,int[] object2 ) -> {
			if(object1[0]!= object2[0])
				return object1[0] - object2[0];
			else
				return object1[1] - object2[1];
			
			});
		
		
	return input;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
	}

}
