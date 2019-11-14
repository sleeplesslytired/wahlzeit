package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class LandscapePhotoFactory extends PhotoFactory {
	private static final Logger log = Logger.getLogger(LandscapePhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static LandscapePhotoFactory instance = null;

	/**
	 *
	 */
	protected LandscapePhotoFactory() {
		super();
	}

	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance();
	}

	/**
	 * Public singleton access method.
	 */
	public static synchronized LandscapePhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic LandscapePhotoFactory").toString());
			setInstance(new LandscapePhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(LandscapePhotoFactory landscapePhotoFactory ) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initialize LandscapePhotoFactory twice");
		}

		instance = landscapePhotoFactory;
	}

	/**
	 * @methodtype factory
	 */
	public LandscapePhoto createLandscapePhoto() {
		return new LandscapePhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	public LandscapePhoto createLandscapePhoto(PhotoId id) {
		return new LandscapePhoto(id);
	}

	/**
	 * Creates a new photo with the specified location
	 */
	public LandscapePhoto createLandscapePhoto(Location location) {
		return new LandscapePhoto(location);
	}

	/**
	 * Loads a photo. The Java object is loaded from the Google Datastore, the Images in all sizes are loaded from the
	 * Google Cloud storage.
	 */
	public LandscapePhoto loadLandscapePhoto(PhotoId id) {
		return null;
	}

	
}
