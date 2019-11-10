package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class LandscapePhotoFactory extends PhotoFactory {
	private static final Logger log = Logger.getLogger(LandscapePhotoFactory.class.getName());
	private static LandscapePhotoFactory instance = null;

	protected LandscapePhotoFactory() {
		super();
	}

	public static void initialize() {
		getInstance();
	}

	public static synchronized LandscapePhotoFactory getInstance() {
		if (this.instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic LandscapePhotoFactory").toString());
			setInstance(new LandscapePhotoFactory());
		}

		return instance;
	}

	protected static synchronized void setInstance(LandscapePhotoFactory landscapePhotoFactory ) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initialize LandscapePhotoFactory twice");
		}

		instance = landscapePhotoFactory;
	}

	public LandscapePhoto createLandscapePhoto() {
		return new LandscapePhoto();
	}

	public LandscapePhoto createLandscapePhoto(PhotoId id) {
		return new LandscapePhoto(id);
	}

	public LandscapePhoto createLandscapePhoto(Location location) {
		return new LandscapePhoto(location);
	}

	public LandscapePhoto loadLandscapePhoto(PhotoId id) {
		return null;
	}

	
}
