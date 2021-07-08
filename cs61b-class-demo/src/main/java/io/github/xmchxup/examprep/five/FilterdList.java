package io.github.xmchxup.examprep.five;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class FilterdList<T> implements Iterable<T> {
	private List<T> L;
	private Predicate<T> filter;

	public FilterdList(List<T> l, Predicate<T> filter) {
		L = l;
		this.filter = filter;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<>() {
			int idx = 0;

			@Override
			public boolean hasNext() {
				while (idx < L.size() && !filter.test(L.get(idx))) {
					idx++;
				}
				return idx < L.size();
			}

			@Override
			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				idx++;
				return L.get(idx-1);
			}
		};
	}
}
