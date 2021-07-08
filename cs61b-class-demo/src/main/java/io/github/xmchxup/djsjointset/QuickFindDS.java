package io.github.xmchxup.djsjointset;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class QuickFindDS implements DisjointSets {
	private int[] id;

	public QuickFindDS(int n) {
		this.id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	@Override
	public void connect(int p, int q) {
		if (isConnected(p, q)) return;
		int pId = id[p];
		int qId = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == qId) {
				id[i] = pId;
			}
		}
	}

	@Override
	public boolean isConnected(int p, int q) {
		return id[p] == id[q];
	}
}
