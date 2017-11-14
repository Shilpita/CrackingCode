package Ex4;

import java.util.*;


/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Feb18,2017
 * Problem: Route between Nodes-> Given a directed graph, design an algorithm to 
 * 			find out whether there is a route between 2 nodes
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/
public class FindRoutedNodes {
	public static boolean isReachable(Graph G,int s, int d){
	
		boolean[] visted = new boolean[G.V]; // Array to mark all visited nodes.
		Queue<Integer> queue = new LinkedList<Integer>(); //Queue to track the next node to be visted
		visted[s] = true;
		queue.add(s);
		Iterator i; //iterator for all the nodes connected source node
		while(!queue.isEmpty()){
			int current = queue.poll();
			i = G.getAdj(current).iterator();
			//System.out.println(i.toString());
			while(i.hasNext()){
				int next = (int) i.next();
				if(next==d)
					return true;
				else{
					visted[next]=true;
					queue.add(next);
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
