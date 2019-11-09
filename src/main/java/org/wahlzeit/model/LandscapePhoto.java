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

	public List<String> getLandscapeDescriptors() {
		List<String> landscapeDescriptors = new LinkedList<String>();
		for (String item : this.landscapeDescriptors) {
			landscapeDescriptors.add(item);
		}
		return landscapeDescriptors;
	}

	protected void doAddLandscapeDescriptor(String newDescriptor) throws IllegalArgumentException {
		if (newDescriptor == null) {
			throw new IllegalArgumentException("descriptor is not allowed to be null");
		}

		if (newDescriptor.equals("")) {
			throw new IllegalArgumentException("descripttor should not be empty");
		}

		for (String item : this.landscapeDescriptors) {
			if(item.toUpperCase().equals(newDescriptor.toUpperCase())) {
				throw new IllegalArgumentException("descriptor already exists");
			}
		}

		this.landscapeDescriptors.add(newDescriptor);

	}

	public boolean addLandscapeDescriptor(String newDescriptor) {
		try {
			doAddLandscapeDescriptor(newDescriptor);
		} catch (IllegalArgumentException ex) {
			return false;
		}
		return true;
	}

}
