package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import org.wahlzeit.model.Photo;
import java.util.List;
import java.util.LinkedList;

@Entity
public class LandscapePhoto extends Photo {
	private List<String> landscapeDescriptors = new LinkedList<String>();

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
