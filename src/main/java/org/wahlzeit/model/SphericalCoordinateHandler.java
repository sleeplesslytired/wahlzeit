package org.wahlzeit.model;


public class SphericalCoordinateHandler extends AbstractCoordinateHandler {
	public void setCoordinate(Coordinate coordinate) {
		this.coordinateBody = coordinate.asSpherical();
	}

	public Coordinate getCoordinate() {
		return null;
	}

}
