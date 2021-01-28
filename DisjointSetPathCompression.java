 package Graph;
import java.util.*;

public class DisjointSetPathCompression {
	
	public class Block{
		int parent;
		int rank;
		
	}
		
	
	
	ArrayList<Block> block = new ArrayList();
	int v;
	int e;
	LinkedList<Node> arr;
	DisjointSetPathCompression(int v,int e){
		this.e = e;
		this.v = v;
		arr = new LinkedList();
		for(int i=0;i<v;i++) {
			Block temp = new Block();
			temp.parent = -1;
			temp.rank = 0;
			block.add(temp);
		}
	}
	
	public class Node{
		int from;
		int to;
		Node(int from,int to){
			this.from = from;
			this.to = to;
		}
	}
	
	public void addEdge(int from,int to) {
		Node G = new Node(from,to);
		arr.add(G);
	}
	
	public int Find(int x) {
		if(block.get(x).parent==-1) return x;
		return block.get(x).parent = Find(block.get(x).parent);
		
	
	}
	
	public void Union(int a,int b) {
		
		if(block.get(a).rank>block.get(b).rank) {
			block.get(b).parent = a;
		}
		else if(block.get(a).rank<block.get(b).rank) {
			block.get(a).parent = b;
		}
		else {
			block.get(a).parent = b;
			block.get(b).rank++;
		}
		
	}
	
	public boolean isCycle() {
		for(Node ele:arr) {
			int f = Find(ele.from);
			int t = Find(ele.to);
			if(f==t) return true;
			Union(f,t);
		}
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		DisjointSetPathCompression graph = new DisjointSetPathCompression(v,e);
		for(int i=0;i<e;i++) {
			graph.addEdge(sc.nextInt(),sc.nextInt());
		}
		
		if(graph.isCycle()) System.out.println("Cycle");
		else {
			System.out.println("No Cycle");
		}

	}

}
