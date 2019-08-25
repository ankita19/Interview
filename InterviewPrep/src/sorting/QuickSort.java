package sorting;

public class QuickSort {
	
	public static void quickSort(int[] arr , int start , int end) {
		if(start >= end) return;
	
		int  p  = partition(arr,start,end);
		quickSort(arr,start,p-1);
		quickSort(arr,p+1,end);
	}
	
	
/*
 *lomuto's algorithm for partitioning
 *left <= P <= right
*/	
	public static int partition(int[] arr,int start,int end) {
		int  pivot = arr[end];
		int i =start;
		
		for(int curr = start ; curr < end ; curr++) {
			if(arr[curr] < pivot)
					{
						swap(arr,curr,i);
						i++;
					}
		}
		
		swap(arr,i,end);
		
	return i;
	}
	
	public static void swap(int[] arr,int x, int y) {
		int tmp;
		tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {500,4,6,2,8,200,3,9,0,90,100};
		quickSort(arr, 0, arr.length-1);

		for(int i = 0 ; i< arr.length ;i++) {
			System.out.println(arr[i] + "\n");
		}

	}

}
