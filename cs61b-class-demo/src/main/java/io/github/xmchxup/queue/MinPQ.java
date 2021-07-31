package io.github.xmchxup.queue;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public interface MinPQ<Item> {
	void add(Item x);
	Item getSmallest();
	Item removeSmallest();
	int size();
}
