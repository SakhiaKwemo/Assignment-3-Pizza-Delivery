
public class IllegalPizza extends Exception{
	
	public IllegalPizza (String message) {
			super(message);
	}

	public IllegalPizza () {
			super("Attempt to order a pizza with illegal data");
	}
	
}
