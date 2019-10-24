import java.lang.Math;

public class Coordinate {

	/**
	 * all three values triangulate the coordiante
	 */
	private double x;	
	private double y;
	private double z;

	/**
	 *
	 */
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	public double getDistance(Coordinate endpoint) {
		double xRes = pow(this.x - endpoint.getX());
		double yRes = pow(this.y - endpoint.getY());
		double zRes = pow(this.z - endpoint.getZ());
		return sqrt(xRes + yRes + zRes);
	}

	public boolean isEqual(Coordinate coordinate) {
		if (this.x != coordinate.getX()) {
			return false;
		}

		if (this.y != coordinate.getY()) {
			return false;
		}

		if (this.z != coordinate.getZ()) {
			return false;
		}

		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (! o instanceof Coordinate) {
			return false;
		}

		return isEqual(o);
	} 

}
