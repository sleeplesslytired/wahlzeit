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
	public void TestAddValidLandscapeDescriptorFirst() {
		assertTrue(photo0.addLandscapeDescriptor("Forest"));
	}

	@Test
	public void TestAddValidLandscapeDescriptorMultiple() {
		assertTrue(photo1.addLandscapeDescriptor("Desert"));
		assertTrue(photo1.addLandscapeDescriptor("Coastline"));
		assertTrue(photo1.addLandscapeDescriptor("Lake"));
		assertTrue(photo1.addLandscapeDescriptor("Hills"));
	}
	
	@Test
	public void TestAddNullLandscapeDescriptor() {
		assertFalse(photo0.addLandscapeDescriptor(null));
	}

	@Test
	public void TestAddEmptyLandscapeDescriptor() {
		assertFalse(photo0.addLandscapeDescriptor(""));
	}

	@Test
	public void TestAddRedundantLandscapeDescriptor() {
		assertTrue(photo0.addLandscapeDescriptor("Tundra"));
		assertFalse(photo0.addLandscapeDescriptor("Tundra"));
	}

}
