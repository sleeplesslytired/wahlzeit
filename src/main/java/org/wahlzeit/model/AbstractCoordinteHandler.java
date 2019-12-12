package org.wahlzeit.model;


abstract class AbstractCoordinateHandler {
	protected Coordinate coordinateBody;

	abstract public void setCoordinate(Coordinate coordinate);

	abstract public Coordinate getCoordinate();

	public double getCartesianDistance(Coordinate coordinate) {
		return this.coordinateBody.getCartesianDistance(coordinate);
	}

	abstract public double getCentralAngle();

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (! (o instanceof AbstractCoordinateHandler)) {
			return false;
		}

		Coordinate coordinate = ((AbstractCoordinateHandler) o).coordinateBody;

		return this.coordinateBody.equals(coordinate);
	}
}
