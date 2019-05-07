package array_string;

public class MQS {

	public Integer findKth(int[] arr,int k,int n) {
		if(arr == null || arr.length == 0) return null;
		int start = 0;
		int pivot = partition(arr,start,n);
		if(k == pivot) return arr[pivot];
		if(k < pivot)
				findKth(arr,start,pivot-1);
		else
			  findKth(arr,pivot+1,n-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
