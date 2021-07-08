package io.github.xmchxup.testing;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class DMSList {
	public class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode h) {
			item = i;
			next = h;
		}

		public int max() {
			return Math.max(item, next.max());
		}
	}

	private IntNode sentinel;

	public DMSList() {
		sentinel = new IntNode(-1000, new LastIntNode());
	}

	public class LastIntNode extends IntNode {

		public LastIntNode() {
			super(0, null);
		}

		@Override
		public int max() {
			return 0;
		}
	}

	public int max() {
		return sentinel.next.max();
	}
}
