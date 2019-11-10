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

	@Test
	public TestAddValidLandscapeDescriptorMultiple() {
		asserTrue(photo1.addLandscapeDescriptor("Desert"));
		asserTrue(photo1.addLandscapeDescriptor("Coastline"));
		asserTrue(photo1.addLandscapeDescriptor("Lake"));
		asserTrue(photo1.addLandscapeDescriptor("Hills"));
	}
	
	@Test
	public TestAddNullLandscapeDescriptor() {
		assertFalse(photo0.addLandscapeDescriptor(null));
	}

	@Test
	public TestAddEmptyLandscapeDescriptor() {
		assertFalse(photo0.addLandscapeDescriptor(""));
	}

	@Test
	public TestAddRedundantLandscapeDescriptor() {
		asserTrue(photo0.addLandscapeDescriptor("Tundra"));
		assertFalse(photo0.addLandscapeDescriptor("Tundra"));
	}

}
