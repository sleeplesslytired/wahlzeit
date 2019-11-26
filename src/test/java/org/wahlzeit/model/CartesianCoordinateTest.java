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
		epsilon = 0.1;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInstacitateNullvector() {
		CartesianCoordinate nullvector = new CartesianCoordinate(0., 0., 0.);
	}

	@Test
	public void testCartesianDistanceOtherCartesian0() {
		assertTrue(Math.abs(cartesianCoordinate0.getCartesianDistance(cartesianCoordinate1) - 15.8193) < epsilon);
	}

	@Test
	public void testCartesianDistanceOtherCartesian1() {
		assertTrue(Math.abs(cartesianCoordinate1.getCartesianDistance(cartesianCoordinate0) - 15.8193) < epsilon);
	}

	@Test
	public void testCartesianDistanceSpherical() {
		assertTrue(Math.abs(cartesianCoordinate0.getCartesianDistance(sphericalCoordinate) - 28.4315) < epsilon);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCartesianDistanceNullArgument() {
		cartesianCoordinate0.getCartesianDistance(null);
	}

	@Test
	public void testAsSpherical() {
		SphericalCoordinate sphericalCoordinate = cartesianCoordinate0.asSpherical();
		assertTrue(Math.abs(sphericalCoordinate.getTheta() - Math.PI / 2) < epsilon);
		assertTrue(Math.abs(sphericalCoordinate.getPhi() - (-0.4636)) < epsilon);
		assertTrue(Math.abs(sphericalCoordinate.getRadius() - 5 * Math.sqrt(5)) < epsilon);
	}

	@Test
	public void testNotEquals() {
		assertFalse(cartesianCoordinate0.equals(cartesianCoordinate1));
	}

	@Test
	public void testEquals() {
		SphericalCoordinate sphericalCoordinate = cartesianCoordinate0.asSpherical();
		assertTrue(cartesianCoordinate0.equals(sphericalCoordinate));
	}

}
