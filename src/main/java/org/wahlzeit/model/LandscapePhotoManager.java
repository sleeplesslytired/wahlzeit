package org.wahlzeit.model;

import org.wahlzeit.model.PhotoManager;

import java.util.logging.Logger;
import java.util.Map;
import java.util.HashMap;


public class LandscapePhotoManager extends PhotoManager {

	/**
	 *
	 */
	protected static final PhotoManager instance = new LandscapePhotoManager();

	private static final Logger log = Logger.getLogger(PhotoManager.class.getName());

}
