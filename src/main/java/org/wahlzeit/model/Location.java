package org.wahlzeit.model;


public class Location {
	public final Coordinate coordinate;
	private final String country;

	public Location(Coordinate coordinate, String country) {
		this.coordinate = coordinate;
		this.country = country;
	}

	public Coordinate getCoordinate() {
		return this.coordinate;
	}
}
