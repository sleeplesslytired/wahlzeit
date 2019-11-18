package org.wahlzeit.model;


import java.lang.Math;

public class CartesianCoordinate extends AbstractCoordinate {

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

	public CartesianCoordinate asCartesian() {
		return this;
	}

	public double getCartesianDistance(Coordinate coordinate) {
		CartesianCoordinate endpoint = coordinate.asCartesian();
		return doGetDistance(endpoint);
	}

	private double doGetDistance(CartesianCoordinate endpoint) {
		double xRes = Math.pow(this.x - endpoint.getX(), 2);
		double yRes = Math.pow(this.y - endpoint.getY(), 2);
		double zRes = Math.pow(this.z - endpoint.getZ(), 2);
		return Math.sqrt(xRes + yRes + zRes);
	}

	public double getCentralAngle(Coordinate coordinate) {
		return asSpherical().getCentralAngle(coordinate);
	}

	public SphericalCoordinate asSpherical() {
		double radius = doCalculateSphericalRadius();
		double theta = doCalculateSphericalTheta();
		double phi = doCalculateSphericalPhi();

		return new SphericalCoordinate(theta, phi, radius);
	}

	private double doCalculateSphericalRadius() {
		return Math.sqrt(Math.pow(this.x, 2) +
						 Math.pow(this.y, 2) +
						 Math.pow(this.z, 2)); 
	}

	private double doCalculateSphericalTheta() {
		double res = 0;
		double radius = doCalculateSphericalRadius();
		if (radius == 0) {
			res = Double.MAX_VALUE; 
		} else {
			res = Math.acos(this.z / radius);
		}
		return res;
	}

	private double doCalculateSphericalPhi() {
		return Math.atan2(y, x);
	}

	@Override
	public boolean equals(Object o) {
		if (! (o instanceof Coordinate)) {
			return false;
		}
		Coordinate coordinate = (Coordinate) o;
		return isEqual(coordinate.asCartesian());
	} 

	public double[] doGetCoordinates() {
		double[] res = {this.x, this.y, this.z};
		return res;
	}
	
}
