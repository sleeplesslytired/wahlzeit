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
	public SphericalCoordinate(double theta, double phi, double radius) throws IllegalArgumentException {
		assertLengthGreaterNull(theta, phi, radius);
		this.theta = theta;
		this.phi = phi;
		this.radius = radius;
	}

	final protected void assertLengthGreaterNull(double theta, double phi, double radius) throws IllegalArgumentException {
		if (radius <= 0) {
			throw new IllegalArgumentException("Cannot instancitate radius <= 0");
		}
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

	public CartesianCoordinate asCartesian() throws IllegalArgumentException {
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

	public double getCartesianDistance(Coordinate coordinate) throws IllegalArgumentException {
		assertCoordinateNotNull(coordinate);

		CartesianCoordinate thisAsCartesian = this.asCartesian();

		return thisAsCartesian.getCartesianDistance(coordinate);
	}

	public double getCentralAngle(Coordinate coordinate)  throws IllegalArgumentException {
		assertCoordinateNotNull(coordinate);
		double res;
		SphericalCoordinate asSpherical;

		asSpherical = coordinate.asSpherical();
		res = doGetCentralAngle(asSpherical);

		return res;
	}

	private double doGetCentralAngle(SphericalCoordinate coordinate) {
		double arg = doGetCentralAngleRootArgument(coordinate);

		return 2 * Math.asin(Math.sqrt(arg));
	}

	private double doGetCentralAngleRootArgument(SphericalCoordinate coordinate) {
		double arg;
		double deltaPhi, deltaTheta;

		deltaPhi = Math.abs(this.phi - coordinate.getPhi()); 
		deltaTheta = Math.abs(this.theta - coordinate.getTheta());
		arg = Math.pow(Math.sin(deltaPhi / 2), 2);
		arg += Math.cos(this.getPhi()) *
			   Math.cos(coordinate.getPhi()) *
			   Math.pow((deltaTheta / 2), 2);

		if (arg < 0) {
			throw new ArithmeticException("Calculating central angle would lead to a complex number, wich is not supported");
		}
		
		return arg;
	}

	public SphericalCoordinate asSpherical() {
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (! (o instanceof Coordinate)) {
			return false;
		}
		Coordinate coordinate = (Coordinate) o;
		return isEqual(coordinate.asSpherical());
	} 

	public double[] getCoordinatesAsArray() {
		double[] res = {this.theta, this.phi, this.radius};
		return res;
	}

}
