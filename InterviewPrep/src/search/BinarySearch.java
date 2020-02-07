package search;

import java.util.Arrays;
import java.util.Comparator;

//O(T) = O(logn)
public class BinarySearch implements Comparator<String> {
	
	
public static boolean binarySearch(int[] num, int k, int s , int e) {
	while(s <= e ) {
			int mid = s + (e-s)/2;
		if(num[mid] == k) return true;
		else if(num[mid] > k) 
			e=mid-1;
		else s= mid+1;
	 }	
		
		return false;
}
	
	
	public int compare(String o1, String o2) {
	
		return o1.compareTo(o2);
	}

	public static boolean binarySearch(int[] a,int find) {
		if(a.length == 0) return false;
		
		int low =0 , high = a.length-1;
		
		while(low <= high) {
			int mid = (low  + (high-low)/2);		
			if(find == a[mid]) {
				return true;
			}else if(find > a[mid]) {
				low = mid+1;
			}else if(find < a[mid]){
				high = mid-1;
			}			
		}
		return false;
	}
	
	public static boolean binarySearchString(String[] a,String find) {
		if(a.length == 0) return false;
		
		int low =0 , high = a.length-1;	
		while(low <= high) {
			int mid = (low  + (high-low)/2);		
			if(find.equals(a[mid])) {
				return true;
			}else if(find.compareTo(a[mid]) > 0 ) {
				low = mid+1;
			}else if(find.compareTo(a[mid]) < 0){
				high = mid-1;
			}			
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println("Int "+binarySearch(new int[]{1,2,3,4,5,6,7},2));
		//System.out.println("String : "+binarySearchString(new String[]{"ankita","ram","sir","book","test","book"} , "try"));
		System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7},8,0,6));
	
	}

	
	
	

}
