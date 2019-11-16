package org.wahlzeit.model;


public interface Coordinate {
	public CartesianCoordinate asCartesian();

	public double getCartesianDistance(Coordinate coordinate);

	public SphericalCoordinate asSpherical();

	public double getSphericalDistance(Coordinate coordinate);

	public boolean isEqual(Coordinate coordinate);
}
