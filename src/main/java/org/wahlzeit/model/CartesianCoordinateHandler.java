package org.wahlzeit.model;


public class CartesianCoordinateHandler extends AbstractCoordinateHandler {
	public void setCoordinate(Coordinate coordinate) {
		this.coordinateBody = coordinate.asCartesian();
	}

	public Coordinate getCoordinate() {
		return null;
	}
}
