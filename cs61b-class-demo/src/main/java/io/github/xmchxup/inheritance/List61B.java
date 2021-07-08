package io.github.xmchxup.inheritance;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public interface List61B<Item> {
	void addFirst(Item x);

	void addLast(Item y);

	Item getFirst();

	Item getLast();

	Item removeLast();

	Item get(int i);

	void insert(Item x, int position);

	int size();

	default void print() {
		int size = size();
		for (int i = 0; i < size; i += 1) {
			System.out.print(get(i) + " ");
		}
	}
}
