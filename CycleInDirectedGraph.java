package Graph;
import java.util.*;

public class CycleInDirectedGraph {
	int V;
	ArrayList<LinkedList<Integer>> arr;
	CycleInDirectedGraph(int V){
		this.V =V;
		arr = new ArrayList<>();
		for(int i=0;i<V;i++) {
			arr.add(new LinkedList<>());
		}
	}
	public void addEdge(int from,int to) {
		arr.get(from).add(to);
	}
public void isCyclic() {
	

		boolean temp = false;
		boolean isVisited[] = new boolean[V];
		boolean cur_stack[] = new boolean[V];
		for(int i=0;i<V;i++) {
			if(isVisited[i] == false) {
				temp = isCyclic_helper(i,isVisited,cur_stack);
		
				if(temp == true) break;
			}
		}
		System.out.println(temp);
	}
	public boolean isCyclic_helper(int src,boolean isVisited[],boolean cur_stack[]) {
		

		isVisited[src] = true;
		cur_stack[src] = true;
		for(int ele:arr.get(src)) {
			if(isVisited[ele]==false) {
				 return isCyclic_helper(ele,isVisited,cur_stack);
			}
				
			
			else if(cur_stack[ele] == true) {

				return true;
			}
		}
		
		cur_stack[src] = false;
		return false;
	}

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		CycleInDirectedGraph G = new CycleInDirectedGraph(V);
		for(int i=0;i<E;i++) {
			G.addEdge(sc.nextInt(), sc.nextInt());
		}
		G.isCyclic();
		

	}

}
