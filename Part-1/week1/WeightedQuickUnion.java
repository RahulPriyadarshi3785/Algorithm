package Week1;

import java.util.Arrays;

public class WeightedQuickUnion {
	
	private int[] uf;
	private int[] size;
	
	public WeightedQuickUnion(int size){
		this.uf = new int[size];
		this.size = new int[size];
		for(int i = 0; i < size; i++)
			this.uf[i] = i;
		Arrays.fill(this.size, 1);
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
		int p_root = root(p);
		int q_root = root(q);
		if(p_root == q_root)
			return;
		else if(size[p_root] > size[q_root]) {
			uf[q_root] = p_root;
			size[p_root] += size[q_root];
		}else {
			uf[p_root] = q_root;
			size[q_root] += size[p_root];
		}
	}
	
}
