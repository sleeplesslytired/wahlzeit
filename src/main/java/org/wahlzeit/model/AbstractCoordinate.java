package org.wahlzeit.model;


abstract class AbstractCoordinate implements Coordinate {

	protected final double epsilon = 0.1;

	abstract public CartesianCoordinate asCartesian();

	abstract public double getCartesianDistance(Coordinate coordinate);

	abstract public SphericalCoordinate asSpherical();

	abstract public double getCentralAngle(Coordinate coordinate);

	abstract public boolean isEqual(Coordinate coordinate);

	abstract public double[] doGetCoordinates();

}
