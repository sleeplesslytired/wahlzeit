package org.wahlzeit.model.landscape;


public class LandscapeCharacteristic {
	private final String characteristic;

	public LandscapeCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	public String getCharacteristic() {
		return this.characteristic;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof LandscapeCharacteristic)) {
			return false;
		}

		LandscapeCharacteristic other = (LandscapeCharacteristic) o;
		return other.getCharacteristic().equals(this.getCharacteristic());
	}

}
