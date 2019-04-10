package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphAdjMatrix extends Graph {

	static int[][] adjMatrix;

	GraphAdjMatrix() {
		// this.adjMatrix = new int[][] {{0,0,1,},{0,0,0},{0,1,0}};

		
		  this.adjMatrix = new int[][] {{1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0},
		  {0,0,0,0,0}};
		 

		//this.adjMatrix = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GraphAdjMatrix matrix = new GraphAdjMatrix();
		boolean[] visited = new boolean[matrix.adjMatrix.length];

		// System.out.println(Arrays.toString(matrix.getNeighbour(0).toArray()));
		matrix.dfs();
	}

	// @Override
	public static ArrayList<Integer> getNeighbour(int v) {
		ArrayList<Integer> neighbour = new ArrayList<>();
		for (int i = 0; i < adjMatrix.length; i++) {
			if (adjMatrix[v][i] == 1) {
				neighbour.add(i);
			}
		}
		return neighbour;
	}

	public void dfs() {
		int size = adjMatrix.length;
		boolean[] visited = new boolean[size];
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				count++;
				visitGraph(visited, i);
			}
		}
		System.out.println(count);
	}

	void visitGraph(boolean[] visited, int sv) {
		visited[sv] = true;
		// System.out.println(sv);

		ArrayList<Integer> neighbour = getNeighbour(sv);
		neighbour.forEach(vertex -> {
			if (!visited[vertex]) {
				visitGraph(visited, vertex);
			}
		});

	}
	
	
	public void bfs() {
		Queue<Integer> que = new LinkedList<>();
		int size = adjMatrix.length;
		boolean[] visited = new boolean[size];
		int count =0;
		for(int i=0 ; i<size;i++) {
			
			if(!visited[i]) {
				count++;
				visited[i] = true;
				que.add(i);
				while(!que.isEmpty()) {
					if(!visited[que.peek()])
						{
						int node = que.poll();
						System.out.println(node);
						que.addAll(getNeighbour(node));
						}
					
					
				}
				
			}
			
			
		}
		
		System.out.println(count);
		
	}

}
