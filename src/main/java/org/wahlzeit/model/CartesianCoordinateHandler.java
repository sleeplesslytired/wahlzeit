package org.wahlzeit.model;


public class CartesianCoordinateHandler extends AbstractCoordinateHandler {
	public CartesianCoordinateHandler(Coordinate coordinate) {
		this.coordinateBody = coordinate.asCartesian();
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinateBody = coordinate.asCartesian();
	}

	public void setCoordinate(double x, double y, double z) throws IllegalArgumentException {
		try {
			CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);
			this.coordinateBody = coordinate;
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Tried to set a body coordinate with length 0 to a CartesianCoordinateHandler!");
		}
	}

	public Coordinate getCoordinate() {
		return this.coordinateBody;
	}

	public double getX() {
		return this.coordinateBody.asCartesian().getX();
	}

	public double getY() {
		return this.coordinateBody.asCartesian().getY();
	}

	public double getZ() {
		return this.coordinateBody.asCartesian().getZ();
	}

	public double getCentralAngle() {
		return -1;
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

}
