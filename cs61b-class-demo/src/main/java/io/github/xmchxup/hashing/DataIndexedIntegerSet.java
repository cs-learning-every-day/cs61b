package io.github.xmchxup.hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class DataIndexedIntegerSet {
	private boolean[] present;

	public DataIndexedIntegerSet() {
		present = new boolean[2000000000];
	}

	public void add(int i) {
		present[i] = true;
	}

	public boolean contains(int i) {
		return present[i];
	}

}
