package Ex4.General;

import java.util.*;

public class Graph {
	public int V ;
	LinkedList<Integer> adj[];
	
	public Graph(int v){
		this.V = v;
		adj = new LinkedList[v];
		for(int i = 0 ; i< v; i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int s, int d){
		adj[s].add(d);
	}
	//LinkedList<Vertex> V;
	//LinkedList<Edge> E;

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public LinkedList<Integer> getAdj(int s) {
		return adj[s];
	}

	public void setAdj(LinkedList<Integer>[] adj) {
		this.adj = adj;
	}
}

class Vertex{
	int id;
	char name;
	
	Vertex(int id , char name){
		this.id = id;
		this.name = name;
	}

}

class Edge{
	int id;
	Vertex source;
	Vertex destination;
	
	Edge(int id ,Vertex source , Vertex destination){
		this.id = id;
		this.source = source;
		this.destination = destination;
	}
	
	public String toString(){
		return this.source+"->"+this.destination;
	}
}