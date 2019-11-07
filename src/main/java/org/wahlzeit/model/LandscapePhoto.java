package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import org.wahlzeit.model.Photo;

@Entity
public class LandscapePhoto extends Photo {

	public LandscapePhoto() {
		super();
	}

	public LandscapePhoto(PhotoId myId) {
		super(myId);
	}

	public LandscapePhoto(Location location) {
		super(location);
	}

}
