package org.wahlzeit.model.landscape;


import org.wahlzeit.model.*;


public class Landscape {
	private Location location;
	private LandscapeType landscapeType;

	public Landscape(Location location) {
		this.location = location;
	}

	public Landscape(Location location, LandscapeType landscapeType) {
		this.location = location;
		this.landscapeType = landscapeType;
	}

	public Location getLocation() {
		return this.location;
	}

}
