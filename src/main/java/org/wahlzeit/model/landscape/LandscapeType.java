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

	public Iterator<LandscapeType> getSubTypesIterator() {
		return this.subTypes.iterator();
	}

	public void addSubType(LandscapeType subType) {
		if (subType == null) {
			throw new IllegalArgumentException("con not add null as sub type to a landscape type!");
		}

		this.subTypes.add(subType);

		subType.superType = this;
		subType.addCharacteristics(this.getCharacteristicsIterator());
	}

	public void addSubTypes(Iterator<LandscapeType> subTypes) {
		if (subTypes == null) {
			throw new IllegalArgumentException("can not add subTypes from a null iterator to a landscape type!");
		}

		while (subTypes.hasNext()) {
			this.addSubType(subTypes.next());
		}
	}

	public boolean hasInstance(Landscape landscape) {
		if (landscape == null) {
			throw new IllegalArgumentException("can not check for subtypes on a null landscape!");
		}

		if (landscape.getLandscapeType() == this) {
			return true;
		}

		Iterator<LandscapeType> subTypes = this.subTypes.iterator();
		while (subTypes.hasNext()) {
			if (subTypes.next().hasInstance(landscape)) {
				return true;
			}
		}

		return false;
	}

	public Landscape createInstance(Location location) {
		return new Landscape(location, this);
	}

}
