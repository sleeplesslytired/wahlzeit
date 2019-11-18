package org.wahlzeit.model;


import java.lang.Math;

public class SphericalCoordinate extends AbstractCoordinate {

	/**
	 * all three spherical coordinates
	 */
	private final double theta;
	private final double phi;
	private final double radius;

	/**
	 *
	 */
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
		double x = doCalculateCartesianX();
		double y = doCalculateCartesianY();
		double z = doCalculateCartesianZ();

		return new CartesianCoordinate(x, y, z);
	}

	private double doCalculateCartesianX() {
		return this.radius * Math.sin(this.theta) * Math.cos(this.phi);
	}

	private double doCalculateCartesianY() {
		return this.radius * Math.sin(this.theta) * Math.sin(this.phi);
	}

	private double doCalculateCartesianZ() {
		return this.radius * Math.cos(this.theta);
	}

	public double getCartesianDistance(Coordinate coordinate) {
		CartesianCoordinate thisAsCartesian = this.asCartesian();
		return thisAsCartesian.getCartesianDistance(coordinate);
	}

	public double getCentralAngle(Coordinate coordinate) {
		return doGetCentralAngle(coordinate.asSpherical());
	}

	private double doGetCentralAngle(SphericalCoordinate coordinate) {
		double arg = 0.;
		double deltaPhi = Math.abs(this.phi - coordinate.getPhi()); 
		double deltaTheta = Math.abs(this.theta - coordinate.getTheta());

		arg += Math.pow(Math.sin(deltaPhi / 2), 2);
		arg += Math.cos(this.getPhi()) *
			   Math.cos(coordinate.getPhi()) *
			   Math.pow((deltaTheta / 2), 2);
		
		return 2 * Math.asin(Math.sqrt(arg));
	}

	public SphericalCoordinate asSpherical() {
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (! (o instanceof Coordinate)) {
			return false;
		}
		return isEqual((Coordinate) o);
	} 

	public boolean isEqual(Coordinate coordinate) {
		return isEqual(coordinate.asSpherical());
	}

	public boolean isEqual(SphericalCoordinate coordinate) {
		if (Math.abs(this.radius - coordinate.getRadius()) >= this.epsilon) {
			return false;
		}

		if (Math.abs(this.theta - coordinate.getTheta()) >= this.epsilon) {
			return false;
		}

		if (Math.abs(this.phi - coordinate.getPhi()) >= this.epsilon) {
			return false;
		}

		return true;
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
