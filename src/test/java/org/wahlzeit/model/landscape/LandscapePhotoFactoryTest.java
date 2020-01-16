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
	HashSet<LandscapeCharacteristic> landscapeCharacteristics;
	Landscape landscape;
	LandscapeType desert;
	
	@Before
	public void init() {
		location = new Location(new CartesianCoordinate(4, 2, 3));

		landscapeCharacteristics = new HashSet<LandscapeCharacteristic>();
		landscapeCharacteristics.add(new LandscapeCharacteristic("barren"));
		landscapeCharacteristics.add(new LandscapeCharacteristic("monoton"));
		landscapeCharacteristics.add(new LandscapeCharacteristic("life hostile"));

		desert = new LandscapeType("desert");
		desert.addCharacteristics(landscapeCharacteristics.iterator());

		LandscapeManager landscapeManager = LandscapeManager.getInstance();
		landscapeManager.addLandscapeType(desert);
		landscape = landscapeManager.createLandscape(location, desert);
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
		assertTrue(LandscapePhotoFactory.getInstance().createPhoto(location, desert) != null);
	}

	@Test
	public void testCreatePhotoCartesianCoordinates() {
		assertTrue(LandscapePhotoFactory.getInstance().createPhotoCartesianCoordinates(2, 3, 4, desert) != null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateLandscapePhotoCartesianCoordinatesInvalid() {
		LandscapePhotoFactory.getInstance().createPhotoCartesianCoordinates(0, 0, 0, desert);
	}

	@Test
	public void testCreatePhotoSphericalCoordinates() {
		assertTrue(LandscapePhotoFactory.getInstance().createPhotoSphericalCoordinates(2, 3, 4, desert) != null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateLandscapePhotoSphericalCoordinatesInvalid() {
		LandscapePhotoFactory.getInstance().createPhotoSphericalCoordinates(0, 0, 0, desert);
	}
}
