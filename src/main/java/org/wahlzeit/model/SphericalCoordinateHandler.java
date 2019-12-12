package org.wahlzeit.model;


public class SphericalCoordinateHandler extends AbstractCoordinateHandler {
	public SphericalCoordinateHandler(Coordinate coordinate) {
		this.coordinateBody = coordinate.asSpherical();
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinateBody = coordinate.asSpherical();
	}

	public void setCoordinate(double theta, double phi, double radius) throws IllegalArgumentException {
		try {
			SphericalCoordinate coordinate = new SphericalCoordinate(theta, phi, radius);
			this.coordinateBody = coordinate;
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Tried to set a body coordinate with length 0 to a SphericalCoordinateHandler!");
		}
	}

	public Coordinate getCoordinate() {
		return this.coordinateBody;
	}

	public double getTheta() {
		return this.coordinateBody.asSpherical().getTheta();
	}

	public double getPhi() {
		return this.coordinateBody.asSpherical().getPhi();
	}

	public double getRadius() {
		return this.coordinateBody.asSpherical().getRadius();
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

}
