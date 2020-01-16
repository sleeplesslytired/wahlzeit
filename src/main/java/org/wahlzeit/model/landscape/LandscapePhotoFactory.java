package org.wahlzeit.model.landscape;

import java.util.Set;

import org.wahlzeit.model.*;
import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;


@PatternInstance(
	patternName = "Abstract Factory",
	participants = {"AbstractFactory",
					"ConcreteFactory"}
)
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
	public LandscapePhoto createPhoto(Landscape landscape) {
		return new LandscapePhoto(landscape);
	}

	/**
	 * @methodtype factory
	 */
	public LandscapePhoto createPhoto(Location location, LandscapeType landscapeType) {
		LandscapeManager landscapeManager = LandscapeManager.getInstance();
		Landscape landscape = landscapeManager.createLandscape(location, landscapeType);
		return new LandscapePhoto(landscape);
	}

	/**
	 * @methodtype factory
	 */
	public LandscapePhoto createPhotoCartesianCoordinates(double x, double y,double z,
									  LandscapeType landscapeType) throws IllegalArgumentException {
		LandscapePhoto res;
		Location location;

		try {
			location = Location.createCartesianDefinedLocation(x, y, z);
			LandscapeManager landscapeManager = LandscapeManager.getInstance();
			Landscape landscape = landscapeManager.createLandscape(location, landscapeType);
			res = new LandscapePhoto(landscape);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException("LandscapePhoto could not be created, due to a location described by the cartesian coordinates (0, 0, 0)");
		}

		return res;
	}

	/**
	 * @methodtype factory
	 */
	public LandscapePhoto createPhotoSphericalCoordinates(double theta, double phi, double radius,
									  LandscapeType landscapeType) throws IllegalArgumentException {
		LandscapePhoto res;
		Location location;

		try {
			location = Location.createSphericalDefinedLocation(theta, phi, radius);
			LandscapeManager landscapeManager = LandscapeManager.getInstance();
			Landscape landscape = landscapeManager.createLandscape(location, landscapeType);
			res = new LandscapePhoto(landscape);
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
