package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.lang.Math;


public class SphericalCoordinateTest {
	
	protected SphericalCoordinate sphericalCoordinate0;
	protected SphericalCoordinate sphericalCoordinate1;
	protected CartesianCoordinate cartesianCoordinate;
	protected double epsilon;

	@Before
	public void setup() {
		sphericalCoordinate0 = new SphericalCoordinate(45., 0., 36.);
		sphericalCoordinate1 = new SphericalCoordinate(270., -50., 90.);
		cartesianCoordinate = new CartesianCoordinate(40., -5., -100.);
		epsilon = 0.1;
	}

	@Test
	public void testCartesianDistance() {
		assertTrue(Math.abs(sphericalCoordinate0.getCartesianDistance(cartesianCoordinate) - 119.3847) < epsilon);
	}

}
