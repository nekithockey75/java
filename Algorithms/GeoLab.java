class GeoLab {
	static final int SIZE = 6;
	static int field[][] = new int[SIZE][SIZE];
	static Point start = new Point();
	static Point finish = new Point();

	public static void main(String[] args) {
		Field.set(field, start, finish);
		Field.generate();
		Field.print();
	}
}
