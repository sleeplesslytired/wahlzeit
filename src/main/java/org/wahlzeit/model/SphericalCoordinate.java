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

	@Override
	public boolean equals(Object o) {
		if (! (o instanceof SphericalCoordinate)) {
			return false;
		}

		return isEqual((SphericalCoordinate) o);
	} 

	public boolean isEqual(Coordinate coordinate) {
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long tmp;
		tmp = Double.doubleToLongBits(this.radius);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(this.theta);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(this.phi);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		return result;
	}

}
