package array_string;

public class FindInRotatedArray {

	//123456
	//561234
	
	public static int findPivot(int[] nums,int low,int high) {
		

		
		int mid =0;
		
		if(nums.length == 0) return -1;
		if(nums.length ==1) return 0;
		
		if(nums[high] > nums[low])
			return 0;
		
		while(low <= high) {
			mid = (low+high)/2;
			
		if(nums[mid] > nums[mid+1])
			return mid+1;
		
		if(nums[low] > nums[mid] ) {
			high = mid-1;
		}else
			low = mid+1;
		
	} 
		return low;
		}

public static int search(int[] nums, int low,int high,int target) {
	if(nums.length ==0) return -1;
	
	if(nums.length ==1) 
		{if(nums[0] != target) 
			return -1; 
			else return 0;
		}
	
	while(low < high) {
		int mid = (low+high/2);
	if(nums[mid] == target)
		return mid;
	else if(nums[mid] > target)
		high = mid-1;
	else 
		low = mid+1;
				
	}
	return -1;
}	
	//456789123
public static int withoutPivot(int[] nums,int target) {
	
	if(nums.length ==0) return -1;

	int low = 0;
	int high = nums.length -1;
	
	while(low<=high) {
		int mid = low+(high-low)/2;
		
		if(nums[mid] == target) return mid;
		//first half is sorted
		if(nums[low] < nums[mid]) { 
			if(nums[low] <= target && target <= nums[mid]) 
				high = mid-1;
			else
				low = mid+1;
			
		}else if(nums[mid] < nums[high]) {
			if(nums[mid] <=target && target <= nums[high])
				low = mid+1;
			else
				high = mid-1;
		}
			
	}
	
	return -1;
	
}
public static void main(String[] args) {
	/*int nums[] = new int[] {4,5,6,7,1};
	int pivot = findPivot(nums,0,4);
	int target = 4;
	int high = nums.length-1;
	int output;
	
	System.out.println("Pivot "+pivot);
	if(target == nums[pivot]) output = pivot;
	
	if(pivot > 0 && target >= nums[0] && target < nums[pivot -1])
		output = search(nums,0,pivot,target);
	else
		output = search(nums,pivot,high,target);
	
	System.out.println(output);
	*/
	System.out.println(withoutPivot(new int[]{4,5,6,7,0,1,2} , 3) +" test");
	
	
}

}
