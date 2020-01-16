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
			throw new IllegalArgumentException("No matching landscape type found to characteristics");
		} 

		Landscape landscape = landscapeType.createInstance(location);

		return landscape;
	}

	public void addLandscapeType(LandscapeType landscapeType) {
		if (!this.landscapeTypes.contains(landscapeType)) {
			this.landscapeTypes.add(landscapeType);
		}
	}

}
