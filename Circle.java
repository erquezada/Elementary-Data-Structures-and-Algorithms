class Circle extends Artifact {
	private double radius;
	public void setRadius(double r) {
		radius = r;
	}
	public double getRadius() {
		return radius;
	}
	public double getArea() {
		return 3.14 * radius * radius;
	}
	public double getPrice() {
		System.out.println("The price is zero: ");
		return 0.0;
	}
}