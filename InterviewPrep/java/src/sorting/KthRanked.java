package sorting;

public class KthRanked {
	
	/*partition
	 * call qSelect until pi = k
	 * */
	
	
	public static int findKthRanked(int[] num ,int k) throws Exception {
		if(num == null || num.length ==0) throw new Exception("invalid input");
		if(k <0 || k > num.length ) throw new Exception("invalid rank");
		
		return qSelect(num,0,num.length-1,k-1);
	}
	
	
	public static int qSelect(int[] a, int start,int end, int k) {
		
		int pi = partition(a,start,end);
		
		if(pi == k) return a[pi];
		
		if(pi < k)
			return qSelect(a, pi+1, end, k);
		else
			return qSelect(a, start, pi-1, k);
		
		} 
	
	public static int partition(int[] a, int start,int end) {
		
		if(start == end) return start;
		
		int mid = start + (end-start)/2;
		swap(a,mid ,end);
		int i=start;
		for(int curr = start; curr < end ; curr++) {
			
			if(a[curr] < a[end]) {
				swap(a,curr,i);
				i++;
			}
		}
		
		swap(a,i,end);
		
		return i;
	}

	public static void swap(int[] a, int i,int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println(findKthRanked(new int[]{4,3,1,2,8},1));
	}

}
