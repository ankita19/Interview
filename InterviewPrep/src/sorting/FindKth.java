package sorting;

public class FindKth {
/*
 * Idea is to use quick sort and find pivot
 * return as soon as we find pivot
 * 
 * */
	public int findKthQuickSelect(int[] arr,int k) throws Exception {
		if(k > arr.length) throw new Exception("Invalid K" + k);
		
		//k = arr.length -k+1;
		
		return helperQS(arr,0,arr.length-1,k-1);
	}
	
	private int helperQS(int arr[],int start,int end,int k) {
		
		int pI = findPivot(arr,start,end);
		
		  if(pI  == k) return arr[pI];
		  if(pI > k)
			  return helperQS(arr,start,pI-1,k);
		  else
			  return helperQS(arr,pI+1,end,k);
	}
	
	
	private int findPivot(int[] arr,int start,int end) {
		int index =start;
		if(start < end) {
			int pi = start+(end-start)/2;
			swap(arr,pi,end);
			int pivot = arr[end];
			
			for(int curr = start ;curr < end;curr++) {
				if(arr[curr] <= pivot) {
					swap(arr,curr,index);
					index++;
				}
			
		}
				swap(arr,index,end);
		}
		
		return index;
	}
	
	public void swap(int[] arr,int a,int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FindKth find = new FindKth();
		System.out.println(find.findKthQuickSelect(new int[]{10,9,2,2,4,6,3,1,8,6,7},3));
	}

}
