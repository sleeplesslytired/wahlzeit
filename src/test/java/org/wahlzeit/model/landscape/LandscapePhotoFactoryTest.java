package org.wahlzeit.model.landscape;

import java.lang.Math;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LandscapePhotoFactoryTest {
	
	@Test
	public void testGetInstanceOnNulledInstanceNotNull() {
		assertTrue(LandscapePhotoFactory.getInstance() != null);
	}

	@Test
	public void testGetInstanceOnInitializedInstanceNotNull() {
		LandscapePhotoFactory.initialize();
		assertTrue(LandscapePhotoFactory.getInstance() != null);
	}

	@Test
	public void testCreateLandscapePhotoCartesianCoordinatesValid() {
		LandscapePhotoFactory landscapePhotoFactory = LandscapePhotoFactory.getInstance();
		assertTrue(landscapePhotoFactory.createLandscapePhotoCartesianCoordinates(14.5,
																				  12.5,
																				  13.5)
				   != null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateLandscapePhotoCartesianCoordinatesInvalid() {
		LandscapePhotoFactory landscapePhotoFactory = LandscapePhotoFactory.getInstance();
		landscapePhotoFactory.createLandscapePhotoCartesianCoordinates(0, 0, 0);
	}
}
