package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class LandscapePhotoFactory extends PhotoFactory {
	private static final Logger log = Logger.getLogger(LandscapePhotoFactory.class.getName());
	private static LandscapePhotoFactory instance = null;

	protected LandscapePhotoFactory() {
		super();
	}

}
