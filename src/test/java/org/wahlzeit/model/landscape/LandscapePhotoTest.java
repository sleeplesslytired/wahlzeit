package org.wahlzeit.model.landscape;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LandscapePhotoTest {
	
	protected LandscapePhoto photo0;
	protected LandscapePhoto photo1;

	@Before
	public void setup() throws Exception {
		photo0 = new LandscapePhoto();
		photo1 = new LandscapePhoto();
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
