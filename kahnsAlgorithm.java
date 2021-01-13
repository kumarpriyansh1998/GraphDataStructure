package Graph;

import java.util.*;

public class kahnsAlgorithm {
	int V;
	ArrayList<LinkedList<Integer>> arr;
	
	kahnsAlgorithm(int V){
		this.V = V;
		arr = new ArrayList<>();
		for(int i=0;i<V;i++) {
			arr.add(new LinkedList<>());
		}
	} 
	
	
	public void addEdge(int from,int to) {
		arr.get(from).add(to);
	}
	
	
	public void khansTopologicalSort() {
		int inDegree[] =new int[V];
		for(int i=0;i<V;i++) {
			for(int ele:arr.get(i)) {
				inDegree[ele]++;
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<V;i++) {
			if(inDegree[i]==0) queue.add(i);
		}
		while(queue.isEmpty()==false){
		
		int temp = queue.poll();
		System.out.print(temp+"->");
		for(int ele:arr.get(temp)) {
			inDegree[ele]--;
			

			if(inDegree[ele]==0) queue.add(ele);
		}
		
		}
		
		
	}

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Vertices: ");
		int V =sc.nextInt();
		System.out.println("Edges: ");
		int E =sc.nextInt();
		kahnsAlgorithm Graph = new kahnsAlgorithm(V);
		for(int i=0;i<E;i++) {
			Graph.addEdge(sc.nextInt(), sc.nextInt());
			
		}
		
		Graph.khansTopologicalSort();

	}

}
