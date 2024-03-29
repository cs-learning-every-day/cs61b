package io.github.xmchxup.disc.discfive;

import java.util.Iterator;

/**
 * @author xmchx (sunhuayangak47@gmail.com)
 */
public class OfficeHourQueue implements Iterable<OHRequest> {
	private OHRequest request;

	public OfficeHourQueue(OHRequest queue) {
		request = queue;
	}

	@Override
	public Iterator<OHRequest> iterator() {
		return new OHIterator(request);
	}

	public static void main(String[] args) {
		OHRequest s1 = new OHRequest("Failing my test for get in arrayDeque, NPE", "Pam", null);
		OHRequest s2 = new OHRequest("conceptual: what is dynamic method selection", "Michael", s1);
		OHRequest s3 = new OHRequest("git: what does checkout do.", "Jim", s2);
		OHRequest s4 = new OHRequest("help", "Dwight", s3);
		OHRequest s5 = new OHRequest("debugging get(i)", "Creed", s4);
		OfficeHourQueue queue = new OfficeHourQueue(s5);
		for (OHRequest r : queue) {
			System.out.println(r.name);
		}
	}
}
