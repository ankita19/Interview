package sorting;

public class SumSubArray {

	int sumSubArray(int[] arr, int start,int end,int sum,int k) {
		if(start == end && sum%k == 0) return 1;
		if(start == end && sum%k != 0) return 0;
		
		//if number is included
		int left = sumSubArray(arr,start+1,end,sum+arr[start],k);
		//if number is not included
		int right = sumSubArray(arr,start+1,end,sum,k);
		
		return left+right;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
