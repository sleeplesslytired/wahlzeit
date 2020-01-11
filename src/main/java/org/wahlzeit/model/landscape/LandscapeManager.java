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

	public Landscape createLandscape(Location location, Set<String> characteristics) {
		LandscapeType landscapeType = this.getLandscapeType(characteristics);	
		if (landscapeType == null) {
			throw new IllegalArgumentException("No matching landscape type found to characteristics");
		}

		Landscape landscape = landscapeType.createInstance(location);

		return landscape;
	}

	protected LandscapeType getLandscapeType(Set<String> characteristics) {
		for (LandscapeType landscapeType : this.landscapeTypes) {
			Iterator<String> landscapeTypeCharacteristics = landscapeType.getCharacteristicsIterator();
			HashSet<String> superSet = new HashSet<String>();	
			while (landscapeTypeCharacteristics.hasNext()) {
				superSet.add(landscapeTypeCharacteristics.next());
			}

			if (superSet.containsAll(characteristics)) {
				return landscapeType;
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
