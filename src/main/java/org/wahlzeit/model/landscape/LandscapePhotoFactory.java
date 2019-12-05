package org.wahlzeit.model.landscape;

import org.wahlzeit.model.*;
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
	public LandscapePhoto createPhoto() {
		return new LandscapePhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	public LandscapePhoto createPhoto(PhotoId id) {
		return new LandscapePhoto(id);
	}

	/**
	 * Creates a new photo with the specified location
	 */
	public LandscapePhoto createPhoto(Location location) {
		return new LandscapePhoto(location);
	}

	/**
	 * Creates a new photo with a location, specified via its cartesian coordinates
	 */
	public LandscapePhoto createLandscapePhotoCartesianCoordinates(double x,
																   double y,
																   double z)
																   throws IllegalArgumentException {
		LandscapePhoto res;
		Location location;

		try {
			location = Location.createCartesianDefinedLocation(x, y, z);
			res = new LandscapePhoto(location);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("LandscapePhoto could not be created, due to a location described by the cartesian coordinates (0, 0, 0)");
		}

		return res;
	}

	/**
	 * Creates a new photo with a location, specified via its spherical coordinates
	 */
	public LandscapePhoto createLandscapePhotoSphericalCoordinates(double theta,
																   double phi,
																   double radius)
																   throws IllegalArgumentException {
		LandscapePhoto res;
		Location location;

		try {
			location = Location.createSphericalDefinedLocation(theta, phi, radius);
			res = new LandscapePhoto(location);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("LandscapePhoto could not be created, due to a location described by spherical coordiantes with length 0");
		}

		return res;
	}

	/**
	 * Loads a photo. The Java object is loaded from the Google Datastore, the Images in all sizes are loaded from the
	 * Google Cloud storage.
	 */
	public LandscapePhoto loadLandscapePhoto(PhotoId id) {
		return null;
	}

	
}
