package org.wahlzeit.model;


abstract class AbstractCoordinateHandler {
	protected Coordinate coordinateBody;

	abstract public void setCoordinate(Coordinate coordinate);

	abstract public Coordinate getCoordinate();

	abstract public double getCartesianDistance();

	abstract public double getCentralAngle();

	@Override
	abstract public boolean equals(Object o);
}
