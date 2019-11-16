package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.lang.Math;


public class CartesianCoordinateTest {
	
	protected CartesianCoordinate cartesianCoordinate0;
	protected CartesianCoordinate cartesianCoordinate1;
	protected SphericalCoordinate sphericalCoordinate;
	protected double epsilon;

	@Before
	public void setup() {
		cartesianCoordinate0 = new CartesianCoordinate(10., -5., 0.);
		cartesianCoordinate1 = new CartesianCoordinate(-5., -10., 0.5);
		sphericalCoordinate = new SphericalCoordinate(45., 0., 36.);
		epsilon = 1;
	}

	@Test
	public void testCartesianDistanceOtherCartesian0() {
		assertTrue(Math.abs(cartesianCoordinate0.getCartesianDistance(cartesianCoordinate1) - 15.) < epsilon);
	}

	@Test
	public void testCartesianDistanceOtherCartesian1() {
		assertTrue(Math.abs(cartesianCoordinate1.getCartesianDistance(cartesianCoordinate0) - 15.) < epsilon);
	}

	@Test
	public void testCartesianDistanceSpherical() {
		assertTrue(Math.abs(cartesianCoordinate0.getCartesianDistance(sphericalCoordinate) - 28) < epsilon);
	}

}
