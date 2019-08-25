package array_string;

public class MQS {

	public int findKth(int[] arr,int k,int n) {
		if(arr == null || arr.length == 0) return -1;
		int start = 0;
		int pivot = partition(arr,start,n);
		if(k == pivot) return arr[pivot];
		if(k < pivot)
				return findKth(arr,start,pivot-1);
		else
			 return findKth(arr,pivot+1,n-1);
		
	}
	
	public int partition(int[] arr,int start,int n) {
		return n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
