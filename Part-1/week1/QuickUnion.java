package Week1;

public class QuickUnion {
	
	private int[] uf;
	
	public QuickUnion(int size){
		uf = new int[size];
		for(int i = 0; i < size; i++)
			uf[i] = i;
	}
	
	public int root(int node) {
		while(node != uf[node]) {
			uf[node] = uf[uf[node]]; //Path Compression - Keeps tree Flat
			//Ackerman's Function keeps it more compact
			node = uf[node];
		}
		return node;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		uf[q] = root(p);
	}
	
	
}
