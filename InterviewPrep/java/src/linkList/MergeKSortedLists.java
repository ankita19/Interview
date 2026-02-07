package linkList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	
	private  class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
   }
	
	//T = O(nklognk)
	//s = O(nk)
	public ListNode  bruteForce(ListNode[] lists) {
		
		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		});
		
		for(ListNode listHead : lists) {
			while(listHead != null) {
				queue.add(listHead);
				listHead = listHead.next;
			}
		}
		
		ListNode dummyHead = new ListNode(-1);
		ListNode runner = dummyHead;
		while(!queue.isEmpty()) {
			runner = queue.poll();
			runner = runner.next;
		}
		
		return dummyHead.next;
	}
	
	
	
	
	//divide and conquer
	
	public ListNode mergeKLists(ListNode[] lists) {  
	    if(lists.length==0) return null;        
	    int interval = 1;
	    while(interval < lists.length){
	        for (int i = 0; i + interval<lists.length; i=i+interval*2)
	            lists[i]=merge2Lists(lists[i],lists[i+interval]);
	      
	        interval*=2;
	    }
	    return lists[0];
	  }

	  public ListNode merge2Lists(ListNode l1, ListNode l2) {
	    if ((l1 == null) && (l2 == null)) return null;    
	    ListNode l3 = new ListNode(0);
	    ListNode currL3=l3;          
	    while ((l1 != null) && (l2 != null)) {
	      if (l1.val < l2.val) {
	        currL3.next = l1;
	        l1 = l1.next;
	      } else {
	        currL3.next = l2;
	        l2 = l2.next;
	      }      
	      currL3 = currL3.next;        
	    }
	    if ((l1 == null) && (l2 != null))
	      currL3.next = l2;
	    if ((l1 != null) && (l2 == null))
	      currL3.next = l1;
	    
	    return l3.next;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
