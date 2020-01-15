import java.io.Serializable;  

public class LineItem implements Serializable,Comparable<LineItem> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1550292139496942749L;
	
	
	final Pizza pizza; 
	int order; 
	
	public void setNumber(int n) throws IllegalPizza {
	
		if(n >= 1 && n <= 100) {
				
				order = n;
		}
		
		else {
			
			throw new IllegalPizza(); 
		}
	}
	
	public LineItem(int n, Pizza otherPizza) throws IllegalPizza{
			
		try {
			
			pizza = otherPizza; 
			setNumber(n);
		
		}
		
		catch(IllegalPizza e) {
			
			throw new IllegalPizza(); 
		}
		
		//this(1, otherPizza); 
		
	}

	public LineItem(Pizza otherPizza) throws IllegalPizza{
		
		try {
			
			pizza = otherPizza; 
			setNumber(1);
		
		}
		
		catch(IllegalPizza e) {
			
			throw new IllegalPizza(); 
		}
		
		//this(1, otherPizza); 
		
	}
	
	public Pizza getPizza() {
	
		return pizza; 
		
	}
	
	public int getOrder() {
		
		return order; 
	}
	
	public double getCost() {
		
		double n = pizza.getCost()*order;;  
		if(order > 20) {
			
			n *= 0.9; 
		}
		
		else if(order > 10 && order < 20){
			
			n *= 0.95; 
		}
		
		return n;   
	}
	
	public String toString() {
		
		if(order < 10) {
			
			return pizza.toString(); 
		}
		
		else {
			
			return " " + pizza.toString(); 
		}
	}
	
	public int compareTo(LineItem otherlineitem) {
		
		double difference = otherlineitem.getCost() - this.getCost(); 
		
		if (Math.abs(difference) < 1.0) {
			
			return 0; 
		}
		
		else {
						
			return (int) difference; 
		}
	}
}
