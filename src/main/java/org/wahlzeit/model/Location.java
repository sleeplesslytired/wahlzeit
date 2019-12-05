package org.wahlzeit.model;


public class Location {
	public final Coordinate coordinate;

	public Location(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public static Location createCartesianDefinedLocation(double x, double y, double z) {
		CartesianCoordinate coordinate;
		Location res;

		try {
			coordinate = new CartesianCoordinate(x, y, z);
			res = new Location(coordinate);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("Location could not be created due to coordinates that are all 0.");
		}
		return res;
	}

	public static Location createSphericalDefinedLocation(double theta, double phi, double radius) {
		SphericalCoordinate coordinate;
		Location res;

		try {
			coordinate = new SphericalCoordinate(theta, phi, radius);
			res = new Location(coordinate);
		} catch (IllegalArgumentException iae) {
			coordinate = new SphericalCoordinate(0.1, 0, 0);
			res = new Location(coordinate);
		}

		return res;
	}

	public Coordinate getCoordinate() {
		return this.coordinate;
	}
}
