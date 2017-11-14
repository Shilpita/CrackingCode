package Ex4;
/**************************************************************************************************************************
 * Author : Shilpita Roy
 * Date   : Mar2,2017
 * Problem: Given a number of Projects and dependencies where first project depend on second, find the build order
 *          Cracking the Coding Interview
 * ***************************************************************************************************************************/
import java.util.*;
import java.io.*;

public class BuildOrder {
	public static List<Integer> order = new ArrayList<Integer>();
	public static int[] visited ;
	public static int[][] graph ;
	
	public static void main(String[] args) {
		int[] projects = {0,1,2,3,4,5};
		int[][] dependencies = {{3, 0}, {1, 5}, {3, 1}, {0, 5}, {2, 3}};   ///{{0,3},{5,2},{2,3},{5,0},{3,2}};
		List<Integer> order1 = buildOrder(projects,dependencies);
		System.out.println(order1.toString());	
	}

	private static List<Integer> buildOrder(int[] projects, int[][] dependencies) {
		int V = projects.length ;
		int E = dependencies.length;
		visited = new int[V];
		Arrays.fill(visited, 0);
		 
	    graph = new int[V][V];
		for(int i = 0 ; i < V ; i++){
			Arrays.fill(graph[i], 0);
			for(int j = 0 ; j<E ; j++){
				int p1 = dependencies[j][0];
				int p2 = dependencies[j][1];
				graph[p2][p1] = 1;
			}
		}
		
		for(int i = 0 ; i < V ; i++){
			if(visited[i] == 0)
				dfs(i , V);
		}
		return order;
	}

	private static void dfs(int i, int V) {
		if(visited[i]== 0){
			visited[i] =1;
			for(int j= 0 ;j < V ; j++){
				if(graph[i][j] == 1 && visited[j] == 0)
					dfs(j,V);
			}
			
			order.add(i);
		}	
	}

}





