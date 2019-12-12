package org.wahlzeit.model;


abstract class AbstractCoordinateHandler {
	protected Coordinate coordinateBody;

	abstract public void setCoordinate(Coordinate coordinate);

	abstract public Coordinate getCoordinate();

	abstract public double getCartesianDistance();

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
