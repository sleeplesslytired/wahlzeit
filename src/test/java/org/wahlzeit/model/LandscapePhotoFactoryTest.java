package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.services.EmailAddress;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LandscapePhotoFactoryTest {
	
	@Test
	public void testGetInstanceOnNulledInstanceNotNull() {
		assertTrue(LandscapePhotoFactory.getInstance() != null);
	}
}
