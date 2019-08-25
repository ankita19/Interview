import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*1)  permutation
 *2)  subset
 *3)  permute Odd and even
 *4)  permute if word
 * 
 * */


public class Recursion {
	
	//1. String permutation
	public static void permuteString(String str) {
		char[] arr = str.toCharArray();
		permuteStringHelper(arr,1);
		
	}
	
	public static void permuteStringHelper(char[] arr,int j) {
		int n = arr.length;
		
		if(j == n-1)
			{System.out.println(Arrays.toString(arr));
			
			return;}
		
		for(int i = j ; i< n ;i++) {
			swap(arr,j,i);
			permuteStringHelper(arr,j+1);
			swap(arr,j,i);
		}
		return;
	} 

	private static void swap(char[] arr , int i , int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	private static void swapInt(int[] arr , int i , int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	//2. find subsets of a set
	public static void findSubset(int[] arr) {
		Integer[] s = new Integer[arr.length];
		
		subsetHelper(arr,s,0,0);
	}
	
	
	public static void subsetHelper(int[] arr, Integer[] s,int i,int j) {
		
		if(i == arr.length)
		{   
			System.out.println(Arrays.toString(s));
			return;
		}
	    s[j] = null;		
		subsetHelper(arr,s,i+1,j);
		s[j] = arr[i];
		subsetHelper(arr,s,i+1,j+1);
		return;
	}
	
	
	
	/*
	 * Assume that the input is an array of size 'n' where 'n' is an even number. Additionally,
	 * assume that half the integers are even and the other half are odd. 
	 * Print only those permutations where odd and even integers alternate, starting with odd.
	 * */
	public static void findPermutationOddEven(int[] arr){
	    int n = arr.length;
	    modifiedPermuteOddEven(arr,0,n);
	    
	}
	//i, 1->n
	public static void modifiedPermuteOddEven(int[] arr,int j,int n){
	    if(j == n-1){
	        System.out.println(Arrays.toString(arr));
	        return;
	    }
	   
	 for(int i = j;i<n-1;i++) {
		
		 if(valueOkToConsider(arr[j],i))
		 {   swapInt(arr,i,j);
			 modifiedPermuteOddEven(arr,j+1,n);
	         swapInt(arr,i,j);
	   }
	 }       
	   
	    return;
	    
	    
	}
	
	public static boolean valueOkToConsider(int v,int i) {
		if((i%2 == 0 && v%2 == 1 )||
				(i%2 == 1 && v%2 == 0)) return true;
		else return false;
	}


	/*
	 * Assume that the input is an array of size 'n' where 'n' is an even number. Additionally,
	 * assume that half the integers are even and the other half are odd. 
	 * Print only those permutations where odd and even integers alternate, starting with odd.
	 * */
	public static void findSubsetModified(int[] arr){
	    int n = arr.length;
	    int[] s = new int[n];
	    
	    modifiedSubset(arr,s,1,0,n);
	    
	}
	//i, 1->n
	public static void modifiedSubset(int[] arr, int[] s,int i,int j,int n){
	    if(i==n){
	        System.out.println(Arrays.toString(s));
	        return;
	    }
	   
	   if(arr[i-1]%2 == 1 && arr[i]%2 == 0) {
	       s[j] = arr[i-1];
	       s[j+1] = arr[i];
	       modifiedSubset(arr,s,i+1,j+2,n);
	   }else{
	       modifiedSubset(arr,s,i+1,j,n);
	   }   
	        
	   
	    return;
	    
	    
	}
	
	
/*Assume that the input is an array of characters. 
 * Print any one permutation that is also a word in the dictionary. 
 * Assume that you have two library functions you can use.
bool ValidWord(char array a) returns true if and only if the string a is a dictionary word.
bool ValidWordPrefix(char array a, int a_size) returns true if and only if a[0...a_size-1] 
is a prefix of at least one word in the dictionary.
 * */
	
	public static boolean findWordPermute(String str) {
		char[] arr = str.toCharArray();
		
		Set<String> wordSet = new HashSet<>();
		wordSet.add("word");
		wordSet.add("word1");	
		
		Set<String> prefixSet = new HashSet<>();
		prefixSet.add("w");
		prefixSet.add("wo");
		prefixSet.add("wor");
		prefixSet.add("word");
		
		return wordPermuteHelper(arr,0,wordSet,prefixSet);
	}
	
	public static boolean wordPermuteHelper(char[] arr,int j,Set<String> wordSet,Set<String> prefixSet){
		int n =arr.length;
		if(j==n-1) {
			if(isDictionaryWord(wordSet,arr)) {
			System.out.println(Arrays.toString(arr));
			return true;
			}
			else return false;		
		
		}
		
		for(int i = j ; i < n ; i++) {
			swap(arr,i,j);
			if(true) {
				if(wordPermuteHelper(arr,j+1,wordSet,prefixSet))
					return true;
			}
			swap(arr,i,j);	
		}
		
		return false;
	}
	
	public static boolean isDictionaryWord(Set<String> wordSet, char[] arr) {
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i < arr.length;i++) {
			sb.append(arr[i]);
			
			
		}
		return wordSet.contains(sb.toString());
	}
	
	public static void main(String[] args) {
		//permuteString("abcd");
		
		//findSubset(new int[]{1,2,3,4});
		//findPermutationOddEven(new int[]{1,2,3,4});
		
		System.out.println(findWordPermute("wodr"));

	}

}
