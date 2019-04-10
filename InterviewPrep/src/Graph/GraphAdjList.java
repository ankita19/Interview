package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GraphAdjList {

	Map<Integer , ArrayList<Integer>> grid = new HashMap<>();
	
	public ArrayList<Integer> getNeighbour(int v){		
		return new ArrayList<Integer>(grid.get(v));
	}
	
	public int dfs(int r , int c) {
		int count = 0;
		int n = 5;
		boolean visited[] = new boolean[n];
		for(int i =0 ; i < r ;i++) {
			if(!visited[i]) {
				count++;
				visitGraph(i,visited);
			}
				
		}
		return count;
	}
public void visitGraph(int i, boolean[] visited) {
		visited[i] = true;
		
		getNeighbour(i).forEach(vertex -> {
			if(!visited[vertex]) {
				visitGraph(vertex , visited);
			} 
		});
}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjList graph = new GraphAdjList();
		graph.grid.put(0, new ArrayList<Integer>());
		graph.grid.put(1, new ArrayList<Integer>());
		graph.grid.put(2, new ArrayList<Integer>());
		graph.grid.put(3, new ArrayList<Integer>());
		graph.grid.put(4, new ArrayList<Integer>());
		
		graph.grid.get(0).add(0);
		graph.grid.get(0).add(1);
		
		graph.grid.get(1).add(0);
		graph.grid.get(1).add(1);
		
		graph.grid.get(2).add(2);
		graph.grid.get(3).add(3);
		graph.grid.get(3).add(4);
		
		
		System.out.println(graph.dfs(graph.grid.size(),5));
	}

}
