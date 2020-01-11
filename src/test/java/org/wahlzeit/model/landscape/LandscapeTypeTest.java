package org.wahlzeit.model.landscape;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import org.wahlzeit.model.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LandscapeTypeTest {
	HashSet<String> desertCharacteristics;
	LandscapeType desert, iceDesert, saltDesert;

	@Before
	public void init() {
		desertCharacteristics = new HashSet<String>();
		desertCharacteristics.add("barren");
		desertCharacteristics.add("little precipation");

		desert = new LandscapeType("desert");
		desert.addCharacteristics(desertCharacteristics.iterator());

		LandscapeType iceDesert = new LandscapeType("ice desert");
		LandscapeType saltDesert = new LandscapeType("salt desert");

		iceDesert.addCharacteristic("damn cold");
		saltDesert.addCharacteristic("damn salty");

		HashSet<LandscapeType> subDeserts = new HashSet<LandscapeType>();
		desert.addSubTypes(subDeserts.iterator());
	}

	@Test
	public void testAddCharacteristic() {
		String characteristic = "life hostile";
		desert.addCharacteristic(characteristic);

		HashSet<String> characteristics = new HashSet<String>();
		Iterator iterator = desert.getCharacteristicsIterator();

		while(iterator.hasNext()) {
			characteristics.add((String) iterator.next());
		}

		assertTrue(characteristics.contains(characteristic));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddCharacteristicInvalid() {
		desert.addCharacteristic(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddCharacteristicsInvalid() {
		HashSet<String> faultyCharacteristics = new HashSet<String>();
		faultyCharacteristics.add("lack of vegetation");
		faultyCharacteristics.add(null);
		desert.addCharacteristics(faultyCharacteristics.iterator());
	}

	@Test
	public void testGetCharacteristics() {
		assertTrue(desert.getCharacteristicsIterator() != null);
	}

	@Test
	public void testAddSubtypess() {
		HashSet<LandscapeType> typesSet = new HashSet<LandscapeType>();
		Iterator<LandscapeType> typeIterator = saltDesert.getSubTypesIterator();

		while(typeIterator.hasNext()) {
			typesSet.add(typeIterator.next());
		}

		assertTrue(typesSet.containsAll(desertCharacteristics));
	}

	@Test
	public void testHasInstanceTrue() {
		Landscape antarctic = new Landscape(new Location(new CartesianCoordinate(1, 2, 3)), iceDesert);
		assertTrue(desert.hasInstance(antarctic));
	}

	@Test
	public void testHasInstanceFalse() {
		LandscapeType rockDesert = new LandscapeType("rock desert");
		rockDesert.addCharacteristic("damn rocky");

		Landscape grandCanion = new Landscape(new Location(new CartesianCoordinate(1, 2, 3)), rockDesert);

		assertFalse(desert.hasInstance(grandCanion));
	}

}
