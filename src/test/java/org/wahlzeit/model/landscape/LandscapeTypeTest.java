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
	HashSet<LandscapeCharacteristic> desertCharacteristics;
	LandscapeType desert, iceDesert, saltDesert;
	LandscapeCharacteristic monoton, barren, cold, salty;

	@Before
	public void init() {
		monoton = new LandscapeCharacteristic("monoton");
		barren = new LandscapeCharacteristic("barren");
		cold = new LandscapeCharacteristic("cold");
		salty = new LandscapeCharacteristic("salty");

		desertCharacteristics = new HashSet<LandscapeCharacteristic>();
		desertCharacteristics.add(monoton);
		desertCharacteristics.add(barren);

		desert = new LandscapeType("desert");
		desert.addCharacteristics(desertCharacteristics.iterator());

		LandscapeType iceDesert = new LandscapeType("ice desert");
		LandscapeType saltDesert = new LandscapeType("salt desert");

		iceDesert.addCharacteristic(cold);
		saltDesert.addCharacteristic(salty);

		HashSet<LandscapeType> subDeserts = new HashSet<LandscapeType>();
		subDeserts.add(iceDesert);
		subDeserts.add(saltDesert);

		desert.addSubTypes(subDeserts.iterator());
	}

	@Test
	public void testAddCharacteristic() {
		LandscapeCharacteristic lifeHostile = new LandscapeCharacteristic("life hostile");
		desert.addCharacteristic(lifeHostile);

		HashSet<LandscapeCharacteristic> characteristics = new HashSet<LandscapeCharacteristic>();
		Iterator iterator = desert.getCharacteristicsIterator();

		while(iterator.hasNext()) {
			characteristics.add((LandscapeCharacteristic) iterator.next());
		}

		assertTrue(characteristics.contains(lifeHostile));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddCharacteristicInvalid() {
		desert.addCharacteristic(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddCharacteristicsInvalid() {
		HashSet<LandscapeCharacteristic> faultyCharacteristics = new HashSet<LandscapeCharacteristic>();
		LandscapeCharacteristic lackOfVegetation = new LandscapeCharacteristic("lack of vegetation");
		faultyCharacteristics.add(lackOfVegetation);
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
		rockDesert.addCharacteristic(new LandscapeCharacteristic("rocky"));

		Landscape grandCanion = new Landscape(new Location(new CartesianCoordinate(1, 2, 3)), rockDesert);

		assertFalse(desert.hasInstance(grandCanion));
	}

}
