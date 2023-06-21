class BoolTest {
	public static void main (String[] args) {
		boolean b;
		b = false;
		System.out.println("b равно " + b);
		b = true;
		System.out.println("b равно " + b);
		if (b) System.out.println("Это выполняется.");
		b = false;			
		if (b) System.out.println("Это не выполняется.");
		System.out.println("10 > 9 равно " + (10 > 9));
	}
}

