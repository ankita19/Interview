package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoint {

	    
	    public class Neighbour implements Comparable<Neighbour>{
	        
	        @Override
			public String toString() {
				return "Neighbour [x=" + x + ", y=" + y + ", distance=" + distance + "]";
			}
			int x;
	        int y;
	        int distance;
	        
	        public Neighbour(int x,int y,int distance){
	            this.x = x;
	            this.y = y;
	            this.distance = distance;
	        }
	      /*  
	        @Override
	        public int compareTo(Neighbour n1,Neighbour n2){
	            return n1.distance - n2.distance;
	        }
*/
			@Override
			public int compareTo(Neighbour o) {
				// TODO Auto-generated method stub
				return this.distance - o.distance;
			}
	    }
	    
	    
	    public int findDistance(int x , int y){
	        
	        return (x*x + y*y);
	    }
	    
	    
	    public int[][] kClosest(int[][] points, int k) {
	        
	        if(points.length == 0 || points[0].length == 0) return null;
	         
	        int output[][] = new int[k][2];
	        
	        PriorityQueue<Neighbour> queue = new PriorityQueue<>();
	        PriorityQueue<Neighbour> queue1 = new PriorityQueue<>((a,b) -> (b.x * b.x) + (b.y + b.y) - (a.y*a.y) -(a.x *a.x) );
	        
	    
	        int row = points.length;
	      
	        for(int i = 0 ; i < row ; i++) {
	        	Neighbour newItem = new Neighbour(points[i][0], points[i][1],findDistance(points[i][0],points[i][1]));
	        System.out.println("newItem: "+newItem.toString());
	        if(queue.size() > k) {
	        	System.out.println(queue.remove().toString());
	        	queue1.remove();
	        }
	                queue.add(newItem);
	                queue1.add(newItem);
	        }
	        System.out.println(queue.size());
	        while(k > 0){
	        	Neighbour n = queue.poll();
	        	System.out.println("new queue "+queue1.poll());
	            output[k-1][0] = n.x;
	            output[k-1][1]= n.y;
	            k--;
	        }
	        
	        return output;
	    }

	    
	    public int[][] findClosest2(int[][] points, int k){
	    	
	    	PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->   (b[0]*b[0] + b[1]*b[1])-  (a[0]*a[0] + a[1]*a[1]));
	    	
	    	for(int[] p : points) {
	    				pq.add(p);
	    		if(pq.size() > k) 
	    			pq.remove();
	    		
	    	}
	    	
	    	int result[][] = new int[k][2];
	    	
	    	while(k-- > 0) {
	    		result[k] = pq.remove();
	    	}
	    	
	    	return result;
	    	
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KClosestPoint closestPoint = new KClosestPoint();
		
	//	int result[][] = closestPoint.kClosest(new int[][] {{1,3},{-2,2},{4,3},{1,1}}, 2);
		//7,8,25,2
	int result[][] = closestPoint.findClosest2(new int[][] {{4,4},{-2,7},{-1,-1},{1,1}}, 2);
 	
	for(int[] a : result) {
		System.out.println(a[0] +" "+a[1]);
	}
	
	
		if(result.equals(new int[][] {{3,3},{1,1}}) || result.equals(new int[][] {{1,1},{3,3}} ))
			System.out.println("true");
		else
			System.out.println("false");
	}

}
