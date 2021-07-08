package io.github.xmchxup.examprep.five;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class IteratorOfIterators implements Iterator<Integer> {
	private LinkedList<Integer> list;

	public IteratorOfIterators(List<Iterator<Integer>> a) {
		list = new LinkedList<>();
		int i = 0;
		while (!a.isEmpty()) {
			Iterator<Integer> curr = a.get(i);
			if (!curr.hasNext()) {
				a.remove(curr);
				i--;
			} else {
				list.add(curr.next());
			}
			if (a.isEmpty()) {
				break;
			}
			i = (i + 1) % a.size();
		}
	}

	@Override
	public boolean hasNext() {
		return !list.isEmpty();
	}

	@Override
	public Integer next() {
		return list.removeFirst();
	}
}
