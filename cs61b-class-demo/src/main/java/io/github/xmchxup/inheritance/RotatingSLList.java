package io.github.xmchxup.inheritance;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class RotatingSLList<Item> extends SLList<Item> {
	public void rotateRight() {
		Item x = removeLast();
		addFirst(x);
	}

}
