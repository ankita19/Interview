package IK.sorting;

import java.util.Arrays;

/*
Problem
==============
Is One set is subset of another ?
=============
Example
============


==============
Solution
============

*/


public class SetIsSubsetOfAnother {

	//O(nlogn)
	public boolean findSetIsSubset(int[] set1,int[] set2){
		int e1= set1.length , e2 = set2.length;	
		Arrays.sort(set1);
		Arrays.sort(set2);
		int match = findMatches(set1,set2,e1,e2);
	if( match == e1 || 	match == e2) {
		return true;
	}else
		return false;
	}
	
	
	public int findMatches(int[] set1,int[] set2,int e1,int e2) {
		int matches =0;
		int s1 =0,s2=0;
		
		while(s1 < e1 && s2 < e2) {
				while(s1 < e1 && s2 < e2 && (set1[s1] != set2[s2])) {
					if(set1[s1] < set2[s2]) {
						s1++;
					}else {
						s2++;
					}
				}
			
		while(s1 < e1 && s2 < e2 && (set1[s1] == set2[s2])) {
					s1++;
					s2++;
					matches++;
				}
		}
		
		return matches;
	}
//optimization over findSetIsSubset
	public boolean findMatches2(int[] set1,int[] set2) {
		
		Arrays.sort(set1);
		Arrays.sort(set2);
	
		int s1 =0,s2=0;
		int e1 = set1.length,e2 = set2.length;
		
		while(s1 < e1 && s2 < e2) {
			if(set1[s1] < set2[s2]) {
				s1++;
			}else if(set1[s1] == set2[s2]) {
				s1++;
				s2++;
			}
			
			if(s2 == e2) return true;
			
			if(set1[s1] > set2[s2]) {
				return false;
			}
			
					
		}
		
		//if(s2 == e2) return true;
		 return false;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SetIsSubsetOfAnother obj = new SetIsSubsetOfAnother();
	//	System.out.println(obj.findSetIsSubset(new int[] {5, 4,3 ,2,9,10},new int[] {1,4}));
		System.out.println(obj.findMatches2(new int[] {1,7,10,13,2,5,6},new int[] {7,2,8}));
	}

}
