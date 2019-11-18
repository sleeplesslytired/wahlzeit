package org.wahlzeit.model;


import java.lang.Math;


abstract class AbstractCoordinate implements Coordinate {

	protected final double epsilon = 0.1;

	abstract public CartesianCoordinate asCartesian();

	abstract public double getCartesianDistance(Coordinate coordinate);

	abstract public SphericalCoordinate asSpherical();

	abstract public double getCentralAngle(Coordinate coordinate);

	public final boolean isEqual(Coordinate coordinate) {
		double[] thisCoordinates = doGetCoordinates();
		double[] thatCoordinates = coordinate.doGetCoordinates();
		for (int i = 0; i < 3; i++) {
			if (Math.abs(thisCoordinates[i] - thatCoordinates[i]) >= epsilon) {
				return false;
			}
		}
		return true;
	}

	abstract public double[] doGetCoordinates();

	@Override
	public final int hashCode() {
		double[] coordinates = doGetCoordinates();
		final int prime = 31;
		int result = 1;
		long tmp;
		for (int i = 0; i < 3; i++) {
			tmp = Double.doubleToLongBits(coordinates[i]);
			result += prime * result + (int) (tmp ^ (tmp >>> 32));
		}
		return result;
	}

}
