package org.wahlzeit.model.landscape;


import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import org.wahlzeit.model.*;


public class LandscapeManager {
	protected static LandscapeManager instance = new LandscapeManager();	
	protected static Set<LandscapeType> landscapeTypes = new HashSet<LandscapeType>();

	public static final LandscapeManager getInstance() {
		return instance;
	}

	public Landscape createLandscape(Location location, LandscapeType landscapeType) {
		if (!this.landscapeTypes.contains(landscapeType)) {
			// throw new IllegalArgumentException("No matching landscape type found to characteristics");
			this.landscapeTypes.add(landscapeType);
		} 

		Landscape landscape = landscapeType.createInstance(location);

		return landscape;
	}

	public Landscape createLandscape(Location location, String landscapeName) {
		LandscapeType landscapeType = this.getLandscapeTypeByName(landscapeName);
		if (!this.landscapeTypes.contains(landscapeType)) {
			throw new IllegalArgumentException("No matching landscape type found to characteristics");
		} 

		return this.createLandscape(location, landscapeType);
	}

	protected LandscapeType getLandscapeTypeByName(String name) {
		Iterator<LandscapeType> types = this.landscapeTypes.iterator();
		
		while(types.hasNext()) {
			LandscapeType type = types.next();
			if (type.getName().equals(name)) {
				return type;
			}
		}

		return null;
	}

	public void addLandscapeType(LandscapeType landscapeType) {
		if (!this.landscapeTypes.contains(landscapeType)) {
			this.landscapeTypes.add(landscapeType);
		}
	}

}
