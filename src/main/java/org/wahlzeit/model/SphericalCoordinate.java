package org.wahlzeit.model;


public class SphericalCoordinate implements Coordinate {

	/**
	 * all three spherical coordinates
	 */
	private final double theta;
	private final double phi;
	private final double radius;

	public SphericalCoordinate(double theta, double phi, double radius) {
		this.theta = theta;
		this.phi = phi;
		this.radius = radius;
	}

	public double getTheta() {
		return this.theta;
	}

	public double getPhi() {
		return this.phi;
	}

	public double getRadius() {
		return this.radius;
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
