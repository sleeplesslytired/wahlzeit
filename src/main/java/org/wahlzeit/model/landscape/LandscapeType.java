package org.wahlzeit.model.landscape;


import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import org.wahlzeit.model.*;


public class LandscapeType {
	protected LandscapeType superType = null;
	protected Set<LandscapeType> subTypes = new HashSet<LandscapeType>();
	protected Set<String> characteristics = new HashSet<String>();

	public LandscapeType() {

	}

	public LandscapeType(LandscapeType superType) {

	}

}
