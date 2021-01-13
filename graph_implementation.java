package Graph;
import java.util.*;

public class graph_implementation {
	int V;
	ArrayList<LinkedList<Integer>> arr;
	
	graph_implementation(int V){
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
	
	public void printGraph() {
		for(int i=0;i<V;i++) {
			System.out.print(i);
			for(int ele:arr.get(i)) {
				System.out.print("->"+ele);
			}
			System.out.println();
		}
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
	}
	
	public void BFS() {
		boolean isVisited[] =new boolean[V];
		for(int i=0;i<V;i++) {
			for(int ele:arr.get(i)) {
				if(isVisited[ele] == false) {
					BFS_helper(ele,isVisited);
					
				}
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
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Vertices:");
		int V = sc.nextInt();
		System.out.print("Edges:");
		int E = sc.nextInt();
		graph_implementation Graph = new graph_implementation(V);
		for(int i=0;i<E;i++) {
			Graph.addEdge(sc.nextInt(), sc.nextInt());
		}
//		Graph.printGraph();
//		Graph.BFS();
		Graph.DFS();
		
		
	}

}
