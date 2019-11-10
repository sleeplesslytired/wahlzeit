package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Test;


public class LandscapePhotoTest extends TestCase {
	
	protected LandscapePhoto photo0;
	protected LandscapePhoto photo1;

	public LandscapePhotoTest(String name) {
		super(name);
	}

	@Test
	public TestAddValidLandscapeDescriptorFirst() {
		assertTrue(photo0.addLandscapeDescriptor("Forest"));
	}


}
