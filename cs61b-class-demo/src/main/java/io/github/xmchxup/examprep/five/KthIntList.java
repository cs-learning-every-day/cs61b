package io.github.xmchxup.examprep.five;

import io.github.xmchxup.lists.IntList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class KthIntList implements Iterator<Integer> {
	public int k;
	private IntList curList;
	private boolean hasNext;

	public KthIntList(int k, IntList curList) {
		this.k = k;
		this.curList = curList;
		this.hasNext = true;
	}

	@Override
	public boolean hasNext() {
		return this.hasNext;
	}

	@Override
	public Integer next() {
		if (!hasNext) {
			throw new NoSuchElementException();
		}

		Integer tmp = curList.first;
		for (int i = 0; i < k && curList != null; i++) {
			curList = curList.rest;
		}
		hasNext = (curList != null);
		return tmp;
	}
}
