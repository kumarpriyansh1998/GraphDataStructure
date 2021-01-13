package Graph;

import java.util.*;

public class BFS_DFS {
	int V;
	ArrayList<LinkedList<Integer>> arr;
	
	BFS_DFS(int V){
		this.V =V;
		arr = new ArrayList<>(V);
		for(int i=0;i<V;i++) {
			arr.add(new LinkedList<>());
		}
	}
	
	public void addEdge(int from,int to) {
		arr.get(from).add(to);
		arr.get(to).add(from);
	}
	
	
	
	public void BFS_helper(int src,boolean isVisited[]) {
		
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		isVisited[src] = true;
		while(queue.isEmpty() == false) {
			int temp = queue.poll();
			System.out.print(temp+"->");
			for(int ele:arr.get(temp)) {
				if(isVisited[ele] == false) {
					queue.add(ele);
					isVisited[ele]= true;
				}
			}
		}
		System.out.println();
	}
	
	public void BFS() {
		boolean isVisited[] =new boolean[V];
		for(int i=0;i<V;i++) {
				if(isVisited[i] == false) {
					BFS_helper(i,isVisited);
					
				}
			
		}
		
	}
	
	public void DFS() {
		boolean isVisited[] = new boolean[V];
		for(int i=0;i<V;i++) {
				if(isVisited[i]== false) {
					dfsHelper(i,isVisited);
					
				}
			
		}
		
		
	}
	public void dfsHelper(int src,boolean isVisited[]) {
		System.out.print(src+"->");
		isVisited[src] = true;
		for(int ele:arr.get(src)) {
			if(isVisited[ele]== false) {
				dfsHelper(ele,isVisited);
			}
			
			
		}
		System.out.println();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Vertices: ");
		int V = sc.nextInt();
		System.out.print("Edges: ");
		int E = sc.nextInt();
		BFS_DFS Graph = new BFS_DFS(V);
		for(int i=0;i<E;i++) {
			Graph.addEdge(sc.nextInt(), sc.nextInt());
		}
		Graph.BFS();
		Graph.DFS();
		

	}

}
