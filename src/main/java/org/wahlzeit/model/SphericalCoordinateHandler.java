package org.wahlzeit.model;


public class SphericalCoordinateHandler extends AbstractCoordinateHandler {
	public SphericalCoordinateHandler(Coordinate coordinate) {
		this.coordinateBody = coordinate.asSpherical();
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinateBody = coordinate.asSpherical();
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

}
