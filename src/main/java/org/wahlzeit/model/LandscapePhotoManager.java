package org.wahlzeit.model;

import org.wahlzeit.model.PhotoManager;

import java.util.logging.Logger;


public class LandscapePhotoManager extends PhotoManager {

	/**
	 *
	 */
	protected static final LandscapePhotoManager instance = new LandscapePhotoManager();

	private static final Logger log = Logger.getLogger(PhotoManager.class.getName());

}
