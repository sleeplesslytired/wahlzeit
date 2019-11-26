package org.wahlzeit.model;


import java.lang.Math;


abstract class AbstractCoordinate implements Coordinate {

	protected final double epsilon = 0.1;

	abstract public CartesianCoordinate asCartesian();

	abstract public double getCartesianDistance(Coordinate coordinate);

	abstract public SphericalCoordinate asSpherical();

	abstract public double getCentralAngle(Coordinate coordinate);

	public final boolean isEqual(Coordinate coordinate) {
		double[] thisCoordinates = getCoordinatesAsArray();
		double[] thatCoordinates = coordinate.getCoordinatesAsArray();
		for (int i = 0; i < 3; i++) {
			if (Math.abs(thisCoordinates[i] - thatCoordinates[i]) >= epsilon) {
				return false;
			}
		}
		return true;
	}

	abstract public double[] getCoordinatesAsArray();

	@Override
	public final int hashCode() {
		double[] coordinates = getCoordinatesAsArray();
		final int prime = 31;
		int result = 1;
		long tmp;
		for (int i = 0; i < 3; i++) {
			tmp = Double.doubleToLongBits(coordinates[i]);
			result += prime * result + (int) (tmp ^ (tmp >>> 32));
		}
		return result;
	}

	protected final void assertCoordinateNotNull(Coordinate coordinate) throws IllegalArgumentException {
		if (coordinate == null) {
			throw new IllegalArgumentException("Received a null reference instead of a Coordinate");
		}
	}

}
