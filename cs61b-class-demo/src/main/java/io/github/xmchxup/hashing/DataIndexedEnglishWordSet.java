package io.github.xmchxup.hashing;

import static io.github.xmchxup.hashing.HashHelper.englishToInt;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class DataIndexedEnglishWordSet {
	private boolean[] present;

	public DataIndexedEnglishWordSet() {
		present = new boolean[2000000000];
	}

	public void add(String word) {
		present[englishToInt(word)] = true;
	}

	public boolean contains(String word) {
		return present[englishToInt(word)];
	}


}
