package io.github.xmchxup.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class ArraySet<T> implements Iterable<T> {
	private T[] items;
	private int size; // the next item to be added will be at position size

	public ArraySet() {
		items = (T[]) new Object[100];
		size = 0;
	}

	/* Returns true if this map contains a mapping for the specified key.
	 */
	public boolean contains(T x) {
		for (int i = 0; i < size; i += 1) {
			if (items[i].equals(x)) {
				return true;
			}
		}
		return false;
	}

	/* Associates the specified value with the specified key in this map. */
	public void add(T x) {
		if (x == null) {
			throw new IllegalArgumentException("can't add null");
		}
		if (contains(x)) {
			return;
		}
		items[size] = x;
		size += 1;
	}

	/* Returns the number of key-value mappings in this map. */
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArraySetIterator();
	}

	private class ArraySetIterator implements Iterator<T> {
		private int curPos = 0;

		@Override
		public boolean hasNext() {
			return curPos < size;
		}

		@Override
		public T next() {
			T item = items[curPos];
			curPos += 1;
			return item;
		}
	}

	@Override
	public String toString() {
		List<String> listOfItems = new ArrayList<>();
		for (T x : this) {
			listOfItems.add(x.toString());
		}
		return "{" + String.join(", ", listOfItems) + "}";
	}

	public static <Glerp> ArraySet<Glerp> of(Glerp... stuff) {
		ArraySet<Glerp> returnSet = new ArraySet<Glerp>();
		for (Glerp x : stuff) {
			returnSet.add(x);
		}
		return returnSet;
	}


	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}

		if (other.getClass() != this.getClass()) {
			return false;
		}
		ArraySet<T> o = (ArraySet<T>) other;
		if (o.size() != this.size()) {
			return false;
		}
		for (T item : this) {
			if (!o.contains(item)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ArraySet<Integer> aset = new ArraySet<>();
		aset.add(5);
		aset.add(23);
		aset.add(42);

		//iteration
		for (int i : aset) {
			System.out.println(i);
		}

		//toString
		System.out.println(aset);

		//equals
		ArraySet<Integer> aset2 = new ArraySet<>();
		aset2.add(5);
		aset2.add(23);
		aset2.add(42);

		System.out.println(aset.equals(aset2));
		System.out.println(aset.equals(null));
		System.out.println(aset.equals("fish"));
		System.out.println(aset.equals(aset));
	}
}
