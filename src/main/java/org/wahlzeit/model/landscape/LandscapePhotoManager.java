package org.wahlzeit.model.landscape;

import org.wahlzeit.model.*;

import java.util.logging.Logger;
import java.util.Map;
import java.util.HashMap;


public class LandscapePhotoManager extends PhotoManager {

	/**
	 *
	 */
	protected static final LandscapePhotoManager instance = new LandscapePhotoManager();

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

	public Photo getPhotoFromId(PhotoId id) {
		if (id == null) {
			return null;
		}

		Photo result = doGetPhotoFromId(id);

		if (result == null) {
			result = LandscapePhotoFactory.getInstance().loadPhoto(id);
			if (result != null) {
				doAddPhoto(result);
			}
		}

		return result;
	}
}
