package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {4,6,2,8,3,9,0};
		mergeSort(arr, 0, arr.length-1);
		for(int i = 0 ; i< arr.length ;i++) {
			System.out.println(arr[i] + "\n");
		}

	}
	
	public static void mergeSort(int[] arr , int start,int end) {
		if(start < end) {
		int mid = start +(end-start)/2;	
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1,end);
		merge(arr,start,end,mid);
		}
	}
	
	public static void merge(int[] arr,int start,int end,int mid) {
		
		
		int[] tmp = new int[arr.length];
		int l=0,r=mid+1,i=0;
		while(l <= mid && r <= end) {
			if(arr[l] <= arr[r])
				{
				tmp[i] = arr[l];
				l++;
				}else {
					tmp[i] = arr[r];
					r++;
				}
			i++;
		}
		
		while(l <= mid) {
			tmp[i] = arr[l];
			i++;
			l++;
		}
		
		while(r <= end) {
			tmp[i] = arr[r];
			i++;
			r++;
		}
		
		for(int j =0; j< end ; j++) {
			arr[j] = tmp[j];
		}
		
	}
	
	
	
	

}
