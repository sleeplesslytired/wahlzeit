package org.wahlzeit.model;


public class Location {
	private final AbstractCoordinateHandler coordinateHandler;

	public Location(AbstractCoordinateHandler coordinateHandler) {
		this.coordinateHandler = coordinateHandler;
	}

	public static Location createCartesianDefinedLocation(double x, double y, double z) {
		CartesianCoordinateHandler coordinateHandler;
		CartesianCoordinate coordinate;
		Location res;

		try {
			coordinate = new CartesianCoordinate(x, y, z);
			coordinateHandler = new CartesianCoordinateHandler(coordinate);
			res = new Location(coordinateHandler);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Location could not be created due to coordinates that are all 0.");
		}
		return res;
	}

	public static Location createSphericalDefinedLocation(double theta, double phi, double radius) {
		SphericalCoordinateHandler coordinateHandler;
		SphericalCoordinate coordinate;
		Location res;

		try {
			coordinate = new SphericalCoordinate(theta, phi, radius);
			coordinateHandler = new SphericalCoordinateHandler(coordinate);
			res = new Location(coordinateHandler);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Location could not be created due to coordinates that are all 0.");
		}

		return res;
	}

	public AbstractCoordinateHandler getCoordinateHandler() {
		return this.coordinateHandler;
	}
}
