package io.github.xmchxup.disc.discfive;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class TYIterator extends OHIterator {

	public TYIterator(OHRequest original) {
		super(original);
	}

	@Override
	public OHRequest next() {
		OHRequest result = super.next();
		if (result.description.contains("thank u") && curr != null && curr.description.contains(
				"thank u")) {
			curr = curr.next;
		}
		return result;
	}
}
