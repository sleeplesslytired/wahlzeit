package org.wahlzeit.model.landscape;

import com.googlecode.objectify.annotation.Entity;
import org.wahlzeit.model.*;
import java.util.List;
import java.util.LinkedList;


@Entity
@PatternInstance(
	patternName = "Abstract Factory",
	participants = {"AbstractProduct",
					"ConcreteProduct"}
)
public class LandscapePhoto extends Photo {
	private Landscape landscape;
	/**
	 *
	 */
	public LandscapePhoto(Landscape landscape) {
		super();
		this.landscape = landscape;
	}

	public LandscapePhoto(PhotoId id, Landscape landscape) {
		super(id);
		this.landscape = landscape;
	}

	/**
	 * @methodtype constructor
	 */
	public LandscapePhoto(PhotoId myId) {
		super(myId);
	}

	/**
	 * @methodtype get
	 */
	public Landscape getLandscape() {
		return this.landscape;
	}

}
