package org.wahlzeit.model;


public class SphericalCoordinate implements Coordinate {

	/**
	 * all three spherical coordinates
	 */
	private final double theta;
	private final double phi;
	private final double r;

	public SphericalCoordinate(double theta, double phi, double r) {
		this.theta = theta;
		this.phi = phi;
		this.r = r;
	}

	public CartesianCoordinate asCartesian() {
		return null;
	}

	public double getCartesianDistance(Coordinate coordinate) {
		return -1;
	}

	public SphericalCoordinate asSpherical() {
		return null;
	}

	public double getSphericalDistance(Coordinate coordinate) {
		return -1;
	}

	public boolean isEqual(Coordinate coordinate) {
		return false;
	}

}
