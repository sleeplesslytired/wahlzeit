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

	public Coordinate getCoordinate() {
		return this.coordinate;
	}
}
