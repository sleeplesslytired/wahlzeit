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

	private static final Logger log = Logger.getLogger(LandscapePhotoManager.class.getName());

	/**
	 * In-memory cache for photos
	 */
	protected Map<PhotoId, LandscapePhoto> photoCache = new HashMap<PhotoId, LandscapePhoto>();

	/**
	 * 
	 */
	public LandscapePhotoManager() {
		photoTagCollector = LandscapePhotoFactory.getInstance().createPhotoTagCollector();
	}

}
