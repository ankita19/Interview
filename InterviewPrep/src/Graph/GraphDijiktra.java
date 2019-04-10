package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class GraphDijiktra {
	
	List<List<Edge>> adj;
	private Set<Integer>visited ;
	private int[] distance;
	int V;
	PriorityQueue<Edge> queue;
	Map<Integer , Integer> parent;
	
	public GraphDijiktra(int v) {
		this.V = v;
		this.queue = new PriorityQueue<>(V , new Edge());
		this.visited = new HashSet<>();
		this.distance = new int[V];
	}
	
	public List<Edge> getNeighbour(int v ,List<List<Edge>> adj){
		return adj.get(v);
		}
	
	
	
	public void DSD(List<List<Edge>> adj , int source) {
		
		this.adj = adj;
		
		for(int i = 0 ; i < V ; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[source] = 0;
		
		queue.add(new Edge(source , 0));
		
		while(!queue.isEmpty()) {
			
			queue.forEach( x->{
				System.out.println(x.getNode());
			});
			
			
			Edge e = queue.poll();
			
			System.out.println("Removed node "+ e.node);
			
			if(!visited.contains(e.getNode())) {
				visited.add(e.getNode());
			}	
			
				getNeighbour(e.getNode(), adj).forEach(neighbour ->{
				if(!visited.contains(neighbour.getNode())){
						distance[neighbour.getNode()] = Math.min(distance[neighbour.getNode()], distance[e.getNode()]+neighbour.getWeight());
						queue.add(neighbour);
						
						System.out.println("Node to be visited " + neighbour.getNode() );
					}
				});
				
			
		}
		
		
	}
	
	 public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
	        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
	        for (int[] f : flights) {
	            if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
	            prices.get(f[0]).put(f[1], f[2]);
	        }
	        
	        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
	        
	        pq.add(new int[] {0, src, k + 1});
	        
	        while (!pq.isEmpty()) {
	            int[] top = pq.remove();
	            int price = top[0];
	            int city = top[1];
	            int stops = top[2];
	            if (city == dst) return price;
	            if (stops > 0) {
	                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
	                for (int a : adj.keySet()) {
	                    pq.add(new int[] {price + adj.get(a), a, stops - 1});
	                }
	            }
	        }
	        return -1;
	    }
	
	
	public static void main(String[] args) {
		 int v = 3;
		int source = 0;
		
		//Adjacency list representation of weighted graph
		ArrayList<List<Edge>> adj = new ArrayList<List<Edge>>();

		for(int i =0; i < v ; i++) {
			List<Edge> item = new ArrayList<>();
			adj.add(item);
		}
		
		/*// Inputs for the DPQ graph 
        adj.get(0).add(new Edge(1, 9)); 
        adj.get(0).add(new Edge(2, 6)); 
        adj.get(0).add(new Edge(3, 5)); 
        adj.get(0).add(new Edge(4, 3)); 
  
        adj.get(2).add(new Edge(1, 2)); 
        adj.get(2).add(new Edge(3, 4)); 
        */
		
		
		adj.get(0).add(new Edge(1, 100)); 
        adj.get(0).add(new Edge(2, 500)); 
       
        adj.get(1).add(new Edge(2, 100)); 
        
		
        GraphDijiktra dObj = new GraphDijiktra(v);
       /* dObj.DSD(adj, source);
        
        System.out.println("The shorted path from node :"); 
		for (int i = 0; i < dObj.distance.length; i++) 
			System.out.println(source + " to " + i + " is "
							+ dObj.distance[i]); 
		*/
		
    	int[][] flights ={{0,1,100},{1,2,100},{0,2,500}};
		System.out.println(dObj.findCheapestPrice(v,flights, source, 2, 0));
		
	}
	
	
	
	
	
		

}

class Edge implements Comparator<Edge> {
	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	int node;
	int weight;
	
	public Edge() {}
	
	public Edge(int n , int w){
		this.node = n;
		this.weight = w;
	}

	@Override
	public int compare(Edge n1, Edge n2) {
		// TODO Auto-generated method stub
		return n1.weight - n2.weight;
		
	}
}