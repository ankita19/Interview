package array;


/*define length inside of main loop or re-initialize
 *  Method 1) sort nlogn
 *        2) check for next item
 *        	    if(a[i] == a[i-1]+1) length ++
 *              
 *              max = Math.max..
 *      T = O(nlogn)
 *      S = in place sort = O(1)
 *          O(n)
 *      
 * Method 2)
 * add all elements in hash map
 * find element and check for element -1
 * 	if found continue
 * 	else check i++ and length++
 * 
 * max = Math.max(length,max);
 * T = o(n)
 * S = O(n)
 * */

import java.util.HashSet;
import java.util.Set;
public class ConsecutiveSeqInArray {
	
	public static int findSeq(int[] arr){
		
		int max = 0;
		Set<Integer> number = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			number.add(arr[i]);
			}
		
		for(int i: number) {	
			if(number.contains(i-1)) continue;
			int length =0;
				while(number.contains(i++)) 
					length++;
				
			max = Math.max(max, length);
		}
	return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSeq(new int[] {1,2,7,3,4}));
	}

}
