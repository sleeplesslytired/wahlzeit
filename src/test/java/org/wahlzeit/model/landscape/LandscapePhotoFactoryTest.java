package org.wahlzeit.model.landscape;

import java.lang.Math;
import java.util.Set;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import org.wahlzeit.model.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LandscapePhotoFactoryTest {
	Location location;
	HashSet<String> landscapeCharacteristics;
	Landscape landscape;
	
	@Before
	public void init() {
		location = new Location(new CartesianCoordinate(4, 2, 3));

		landscapeCharacteristics = new HashSet<String>();
		landscapeCharacteristics.add("rocky");
		landscapeCharacteristics.add("dusty");
		landscapeCharacteristics.add("hot weather");
		landscapeCharacteristics.add("arid");

		LandscapeType desert = new LandscapeType();
		desert.addCharacteristics(landscapeCharacteristics.iterator());

		LandscapeManager landscapeManager = LandscapeManager.getInstance();
		landscapeManager.addLandscapeType(desert);
		landscape = landscapeManager.createLandscape(location, landscapeCharacteristics);
	}
	
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
	public void testCreatePhotoViaLandscape() {
		assertTrue(LandscapePhotoFactory.getInstance().createPhoto(landscape) != null);
	}

	@Test
	public void testCreatePhotoViaLocationAndDescriptors() {
		assertTrue(LandscapePhotoFactory.getInstance().createPhoto(location, landscapeCharacteristics) != null);
	}

	@Test
	public void testCreatePhotoCartesianCoordinates() {
		assertTrue(LandscapePhotoFactory.getInstance().createPhotoCartesianCoordinates(2, 3, 4, landscapeCharacteristics) != null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateLandscapePhotoCartesianCoordinatesInvalid() {
		LandscapePhotoFactory.getInstance().createPhotoCartesianCoordinates(0, 0, 0, landscapeCharacteristics);
	}

	@Test
	public void testCreatePhotoSphericalCoordinates() {
		assertTrue(LandscapePhotoFactory.getInstance().createPhotoSphericalCoordinates(2, 3, 4, landscapeCharacteristics) != null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateLandscapePhotoSphericalCoordinatesInvalid() {
		LandscapePhotoFactory.getInstance().createPhotoSphericalCoordinates(0, 0, 0, landscapeCharacteristics);
	}
}
