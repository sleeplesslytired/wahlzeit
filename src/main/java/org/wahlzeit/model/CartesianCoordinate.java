package org.wahlzeit.model;


import java.lang.Math;

public class CartesianCoordinate implements Coordinate {

	/**
	 * all three values triangulate the coordiante
	 */
	private final double x;	
	private final double y;
	private final double z;

	/**
	 *
	 */
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	public double getDistance(CartesianCoordinate endpoint) {
		double xRes = Math.pow(this.x - endpoint.getX(), 2);
		double yRes = Math.pow(this.y - endpoint.getY(), 2);
		double zRes = Math.pow(this.z - endpoint.getZ(), 2);
		return Math.sqrt(xRes + yRes + zRes);
	}

	public boolean isEqual(CartesianCoordinate coordinate) {
		if (this.x != coordinate.getX()) {
			return false;
		}

		if (this.y != coordinate.getY()) {
			return false;
		}

		if (this.z != coordinate.getZ()) {
			return false;
		}

		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof CartesianCoordinate)) {
			return false;
		}

		return isEqual((CartesianCoordinate) o);
	} 

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long tmp;
		tmp = Double.doubleToLongBits(x);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(y);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(z);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		return result;
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
