package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

class FindCheapestFlight {
	
    private class City implements Comparable<City>{
        int id;
        int costFromSrc;
        int stopFromSrc;
        public City(int id, int costFromSrc, int stopFromSrc){
            this.id = id;
            this.costFromSrc = costFromSrc;
            this.stopFromSrc = stopFromSrc;
        }
        public boolean equals(City c){
            if(c instanceof City)
                return this.id == c.id;
            return false;
        }
        public int compareTo(City c){
            return this.costFromSrc - c.costFromSrc;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] srcToDst = new int[n][n];
        
        
        //creating matrix of source to destination with weight
        for(int i = 0; i < flights.length; i++)
            srcToDst[flights[i][0]][flights[i][1]] = flights[i][2]; 
        System.out.println("Input ");
        for (int i = 0; i < srcToDst.length; i++) {
            for (int j = 0; j < srcToDst[i].length; j++) {
                System.out.printf("%d ", srcToDst[i][j]);
            }
            System.out.println();
        }
						
        PriorityQueue<City> minHeap = new PriorityQueue();
        
        minHeap.offer(new City(src,0,0));
				
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        cost[src] = 0;
        int[] stop = new int[n];
        Arrays.fill(stop, Integer.MAX_VALUE);
        stop[src] = 0;
				
        while(!minHeap.isEmpty()){
            City curCity = minHeap.poll();
            //if found destination
            if(curCity.id == dst) return curCity.costFromSrc;
            
            //if skip path with more than k stops;
            if(curCity.stopFromSrc == K + 1) continue;
            
            
            int[] nexts = srcToDst[curCity.id];
            
            System.out.println("Print neighbours " + Arrays.toString(nexts));
            
            
            for(int i = 0; i < n; i++){
                if(nexts[i] != 0){
                    int newCost = curCity.costFromSrc + nexts[i];
                    int newStop = curCity.stopFromSrc + 1;
                    
                    //add in queue if cost is less or number of stops < K
                    if(newCost < cost[i]){
                        minHeap.offer(new City(i, newCost, newStop));
                        cost[i] = newCost;
                    }
                    /*
                    else if(newStop < stop[i]){
                        minHeap.offer(new City(i, newCost, newStop));
                        stop[i] = newStop;
                    }*/
                }
            }
        }
        
        return cost[dst] == Integer.MAX_VALUE? -1:cost[dst];
    }
    
    
    public static void main(String []  args) {
    	
    	FindCheapestFlight ff = new FindCheapestFlight();
     	/*int[][] flights ={{0,1,100},{1,2,500},{0,3,100},{3,2,100},{0,2,500}};
    	System.out.println(ff.findCheapestPrice(4, flights, 0, 2, 3));*/
    	
    	
    	int[][] flights ={{0,1,5},{1,3,15},{3,5,1},{0,2,10},{2,3,1},{2,4,1}};
    	System.out.println(ff.findCheapestPrice(6, flights, 0, 5, 2));
    	
    }
}