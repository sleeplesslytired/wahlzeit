package org.wahlzeit.model.landscape;


import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import org.wahlzeit.model.*;


public class LandscapeType {
	protected LandscapeType superType = null;
	protected Set<LandscapeType> subTypes = new HashSet<LandscapeType>();
	protected Set<String> characteristics = new HashSet<String>();

	public LandscapeType() {

	}

	public LandscapeType(LandscapeType superType) {

	}

	public void addCharacteristic(String characteristic) {
		if (characteristic == null) {
			throw new IllegalArgumentException("can not add null as characteristic to a landscape type!");
		}

		this.characteristics.add(characteristic);
	}

	public void addCharacteristics(Iterator<String> characteristics) {
		if (characteristics == null) {
			throw new IllegalArgumentException("can not add characteristics from a null iterator to a landscape type!");
		}

		while (characteristics.hasNext()) {
			this.addCharacteristic(characteristics.next());
		}
	}

	public Iterator<String> getCharacteristicsIterator() {
		return this.characteristics.iterator();
	}

	public LandscapeType getSuperType() {
		return this.superType;
	}

}
