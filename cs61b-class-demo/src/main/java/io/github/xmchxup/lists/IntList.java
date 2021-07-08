package io.github.xmchxup.lists;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class IntList {
	public int first;
	public IntList rest;

	public IntList(int first, IntList rest) {
		this.first = first;
		this.rest = rest;
	}

	/**
	 * Return the size of the list using... recursion!
	 */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + rest.size();
	}

	/**
	 * Return the size of the list using no recursion!
	 */
	public int iterativeSize() {
		IntList p = this;
		int size = 0;
		while (p != null) {
			size++;
			p = p.rest;
		}
		return size;
	}

	/**
	 * Return the ith item of the IntList.
	 */
	public int get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		IntList p = this;
		for (int i = 0; i < index; i++) {
			p = p.rest;
		}
		return p.first;
	}
//	/**
//	 * Recursion
//	 */
//	public int get(int index) {
//		if (index == 0) {
//			return first;
//		}
//		return rest.get(index - 1);
//	}Government

	/**
	 * Returns an IntList identical to L, but with
	 * each element incremented by x. L is not allowed
	 * to change.
	 */
	public static IntList incrList(IntList L, int x) {
		if (L == null) {
			return null;
		}
		IntList tmp = incrList(L.rest, x);
		tmp = new IntList(L.first + x, tmp);
		return tmp;
	}
//	public static IntList incrList(IntList L, int x) {
//
//		IntList tmp = null;
//		final int size = L.size();
//
//		for (int i = 0; i < size; i++) {
//			tmp = new IntList(-1, tmp);
//		}
//
//		IntList p = tmp;
//		for (int i = 0; i < size; i++) {
//			p.first = L.get(i) + x;
//			p = p.rest;
//		}
//
//		return tmp;
//	}

	/**
	 * Returns an IntList identical to L, but with
	 * each element incremented by x. Not allowed to use
	 * the 'new' keyword.
	 */
	public static IntList dincrList(IntList L, int x) {
		if (L == null) {
			return L;
		}
		L.first += x;
		dincrList(L.rest, x);
		return L;
	}
//	public static IntList dincrList(IntList L, int x) {
//		final int size = L.size();
//
//		IntList p = L;
//		for (int i = 0; i < size; i++) {
//			p.first = L.get(i) + x;
//			p = p.rest;
//		}
//
//		return L;
//	}

	public static IntList square(IntList L) {
		if (L == null) {
			return L;
		}
		IntList tmp = square(L.rest);
		tmp = new IntList(L.first * L.first, tmp);
		return tmp;
	}

	public static IntList squareIt(IntList L) {
		if (L == null) {
			return L;
		}
		IntList head = new IntList(L.first * L.first, null);
		IntList p = head;
		IntList next = L.rest;
		while (next != null) {
			p.rest = new IntList(next.first * next.first, null);
			next = next.rest;
			p = p.rest;
		}
		return head;
	}

	public static IntList squareDestructive(IntList L) {
		if (L == null) {
			return L;
		}
		L.first *= L.first;
		squareDestructive(L.rest);
		return L;
	}

	public static IntList squareDestructiveIt(IntList L) {
		IntList p = L;
		while (p != null) {
			p.first *= p.first;
			p = p.rest;
		}
		return L;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IntList that = (IntList) o;
		if (this.size() != that.size()) {
			return false;
		}
		int size = size();
		IntList p1 = this;
		IntList p2 = that;

		for (int i = 0; i < size; i++) {
			if (p1.first != p2.first) return false;
			p1 = p1.rest;
			p2 = p2.rest;
		}
		return true;
	}

	public static IntList list(int... args) {
		IntList head = new IntList(-1, null);
		IntList p = head;
		for (int arg : args) {
			p.rest = new IntList(arg, p.rest);
			p = p.rest;
		}
		return head.rest;
	}

	public void skippify() {
		IntList p = this;
		int n = 1;
		while (p != null) {
			IntList next = p.rest;
			for (int i = 0; i < n && next != null; i++) {
				next = next.rest;
			}
			p.rest = next;
			p = p.rest;
			n += 1;
		}
	}

	/**
	 * Non-destructively creates a copy of x that contains no occurrences of y.
	 */
	public static IntList ilsans(IntList x, int y) {
		if (x == null) {
			return null;
		}
		if (x.first == y) {
			return ilsans(x.rest, y);
		}
		return new IntList(x.first, ilsans(x.rest, y));
	}

	/**
	 * Destructively modify and return x to contain no occurrences of y,
	 * without using the keyword "new".
	 */
	public static IntList dilsans(IntList x, int y) {
		if (x == null) {
			return null;
		}
		x.rest = dilsans(x.rest, y);
		if (x.first == y) {
			return x.rest;
		}
		return x;
	}


	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
		System.out.println(L.size());
		System.out.println(L.get(0));

		// Test your answers by uncommenting. Or copy and paste the
		// code for incrList and dincrList into IntList.java and
		// run it in the visualizer.
		System.out.println(L.get(1));
		IntList intList = incrList(L, 3);
		dincrList(L, 3);
		IntList square = squareIt(L);
		squareDestructiveIt(L);
		System.out.println("debug");
	}

}
