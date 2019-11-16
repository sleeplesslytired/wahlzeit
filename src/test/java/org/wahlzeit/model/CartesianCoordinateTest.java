package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CartesianCoordinateTest {
	
	protected cartesianCoordinate0;
	protected cartesianCoordinate1;
	protected sphericalCoordinate;

	@Before
	public void setup() {
		cartesianCoordinate0 = new CartesianCoordinate(10., -5., 0.);
		cartesianCoordinate1 = new CartesianCoordinate(-5., -10., 0.5);
		sphericalCoordinate = new SphericalCoordinate(45., 0., 36.);
	}

}
