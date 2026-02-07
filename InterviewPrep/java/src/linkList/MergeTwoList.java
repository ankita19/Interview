package linkList;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> l1 = new ArrayList();
		l1.add(2);
		l1.add(5);

		List<Integer> l2 = new ArrayList();
		l2.add(3);
		l2.add(4);
		System.out.println(merge_list(l1,l2));

	}
	
	public static List<Integer> merge_list(List<Integer> l1 , List<Integer> l2) {
		
		List<Integer> l3 = new ArrayList<Integer>();
		int l = l1.size() + l2.size();
		//one list is empty
		if(l1.size() == 0) {
			return l2;
		}else if(l2.size() == 0)
		{
			return l1;
		}
		int item1 =0 , item2 =0,t1=0,t2=0;
		
		for(int i = 0  ; i < l;i++){
		
		//if l1 runs out
			if(t1 < l1.size()) {
		    item1 = l1.get(t1);
		    }
			else {
			while(t2 < l2.size()) {	
				l3.add(l2.get(t2));
				t2++;
				}
			return l3;
			}
			//if l2 runs out
			if(t2 < l2.size()) {
			item2 = l2.get(t2);
			}else {
				while(t1 < l1.size()) {	
					l3.add(l1.get(t1));
					t1++;
					}
				return l3;
				}
		if( item1 <= item2) {
			  	l3.add(item1);
			  	t1++;
			} else {
				l3.add(item2);
				t2++;
			}
		}	
	return l3;
		
	}

}
