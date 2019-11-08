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

	public void addLandscapeDescriptor(String newDescriptor) {
		for (String item : this.landscapeDescriptors) {
			if(item.toUpperCase().equals(newDescriptor.toUpperCase())) {
				return;
			}
		}

		this.landscapeDescriptors.add(newDescriptor);
	}

}
