package Ex4;

import java.util.*;

/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Feb18,2017
 * Problem: 4.1 Route between Nodes-> Given a directed graph, design an algorithm to 
 * 			find out whether there is a route between 2 nodes
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/
public class FindRoutedNodes_4_1 {
	private static boolean[] visited;

	// To  check if two nodes are connected we can use a BFS from the source till we reach the destination or return false.
	// Time Complexity : O(V+E)   Space Complexity : O(N) for the queue
	public static boolean isReachable(Graph G,int s, int d){
	
		boolean[] visted = new boolean[G.V]; // Array to mark all visited nodes.
		Queue<Integer> queue = new LinkedList<Integer>(); //Queue to track the next node to be visted
		visted[s] = true;
		queue.add(s);
		
		while(!queue.isEmpty()){
			int current = queue.poll();
			for(Integer i : G.getAdj(current)){
				if(visited[i] == false){
					if(i == d)
						return true;
					else{
						visted[i] = true;
						queue.add(i);
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
		
		System.out.println(isReachable(g, 2,3));
	}

}
