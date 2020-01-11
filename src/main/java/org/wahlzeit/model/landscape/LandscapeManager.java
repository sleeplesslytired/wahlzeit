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

}
