package Graph;
import java.util.*;

public class topological_sort {
	int V;
	ArrayList<LinkedList<Integer>> arr;
	
	topological_sort(int V){
		this.V = V;
		arr = new ArrayList<>();
		for(int i=0;i<V;i++) {
			arr.add(new LinkedList<>());
		}
	}
	
	public void addEdge(int from,int to) {
		arr.get(from).add(to);
	}
	public void TopologicalSort() {
		boolean isVisited[] = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<V;i++) {
			if(isVisited[i]==false) helper(isVisited,stack,i);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+"->");
		}
	}
	
	public void helper(boolean isVisited[],Stack stack,int src) {
		isVisited[src] = true;
		for(int ele:arr.get(src)) {
			if(isVisited[ele]==false) helper(isVisited,stack,ele);
		}
		stack.add(src);
		return;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Vertices: ");
		int V =sc.nextInt();
		System.out.println("Edges: ");
		int E =sc.nextInt();
		topological_sort Graph = new topological_sort(V);
		for(int i=0;i<E;i++) {
			Graph.addEdge(sc.nextInt(), sc.nextInt());
			
		}
		
		Graph.TopologicalSort();
		

	}

}
