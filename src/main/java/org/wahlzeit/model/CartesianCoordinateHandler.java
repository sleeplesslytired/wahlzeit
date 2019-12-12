package org.wahlzeit.model;


public class CartesianCoordinateHandler extends AbstractCoordinateHandler {
	public CartesianCoordinateHandler(Coordinate coordinate) {
		this.coordinateBody = coordinate.asCartesian();
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinateBody = coordinate.asCartesian();
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

}
