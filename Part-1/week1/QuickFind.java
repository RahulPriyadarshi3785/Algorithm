package Week1;

public class QuickFind {

	private int[] uf;
	
	public QuickFind(int size){
		uf = new int[size];
		for(int i = 0; i < size; i++)
			uf[i] = i;//[86,5,6,10,1,86,90,5,86,34]
	}
	
	public boolean connected(int p, int q) {
		return uf[p] == uf[q];
	}
	
	public void union(int p, int q) {
		int pid = uf[p];
		int qid = uf[q];
		for(int i = 0; i < uf.length; i++)
			if(uf[i] == pid)
				uf[i] = qid;
	}
	
	

}
