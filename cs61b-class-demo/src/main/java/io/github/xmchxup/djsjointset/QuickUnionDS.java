package io.github.xmchxup.djsjointset;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class QuickUnionDS implements DisjointSets {

	private int[] parent;

	public QuickUnionDS(int n) {
		this.parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	@Override
	public void connect(int p, int q) {
		int pId = find(p);
		int qId = find(q);
		if (pId == qId) return;

		parent[qId] = pId;
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	private int find(int e) {
		while (parent[e] != e) {
			e = parent[e];
		}
		return e;
	}
}
