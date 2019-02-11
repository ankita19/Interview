package array_string;

/*Check if array elements are consecutive
 * Method 1) 
 * Sorting of array
 * 	sort nlogn and see if element are in increasing order
 * 	T= O(nlogn) , S = O(1)/O(n)
 * 
 * Method 2) 
 * calculate length and find distinct
 * 	Find length = max-min+1
 * 	find all element are distinct by visites array 
 * 	visited[a[i]-min] == true
 * 	T(O) = O(n) , S= O(n)
 * 
 * Method 3) use AP formula
 *  find min number
 * do AP = (n(2a*(n-1)d))/2
 * d=1
 * */
public class ConsucutiveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
