package org.wahlzeit.model;


public class Location {
	public final Coordinate coordinate;

	public Location(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate() {
		return this.coordinate;
	}
}