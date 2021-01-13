package Graph;
import java.util.*;

public class Cycle_Detection {
	ArrayList<LinkedList<Integer>> arr;
	int V;

	
	Cycle_Detection(int V){
		this.V = V;
		arr = new ArrayList<>();
		for(int i=0;i<V;i++) {
			arr.add(new LinkedList<>());
		}
		
	}
	
	public void addEdge(int from,int to) {
		arr.get(from).add(to);
		arr.get(to).add(from);
	}
	
	public void isCyclic() {
		
		boolean temp = false;
		boolean isVisited[] = new boolean[V];
		for(int i=0;i<V;i++) {
			if(isVisited[i]==false) {
			temp = isCyclic_helper(i,isVisited,-1);
			if(temp== true) {
				break;
			}
			}
		}
		System.out.println(temp);
		
		
	}
	public boolean isCyclic_helper(int src,boolean isVisited[],int parent) {
		isVisited[src] = true;
		for(int ele:arr.get(src)) {
			if(isVisited[ele]==false) {
				if(isCyclic_helper(ele,isVisited,src)== true) return true;
			}
			else if(ele!=parent) {
				return true;
			}
		
		}
		return false;
		
		
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Vertices:");
		int V =sc.nextInt();
		System.out.print("Edges:");
		int E = sc.nextInt();
		Cycle_Detection Graph = new Cycle_Detection(V);
	
		for(int i=0;i<E;i++) {
			Graph.addEdge(sc.nextInt(), sc.nextInt());
		}
		
		Graph.isCyclic();
		

	}
	

}
