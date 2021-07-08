package io.github.xmchxup.inheritance;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class VengefulSLList<Item> extends SLList<Item> {
	SLList<Item> deletedItems;

	public VengefulSLList() {
		super();
		deletedItems = new SLList<>();
	}

	public VengefulSLList(Item x) {
		super(x);
		deletedItems = new SLList<>();
	}

	public void printLostItems() {
		deletedItems.print();
	}

	@Override
	public Item removeLast() {
		Item item = super.removeLast();
		deletedItems.addLast(item);
		return item;
	}
}
