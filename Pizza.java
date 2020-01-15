import java.io.Serializable; 
import java.text.DecimalFormat;

public class Pizza implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2548381457677871386L;

	enum Size {
		Small(7), Medium(9), Large(11);
		
		Size(double cost)
		{
			this.cost = cost;
		}
		
		final double cost;  		
		
	} 
	
	enum Cheese {
		
		Single(0), Double(1.5), Triple(3); 
		
		final double cost;
		
		Cheese(double cost){
			
			this.cost = cost; 
		} 
	}
	
	enum ExtraTopping {
		
		None(0), Single(1.5); 
		
		ExtraTopping(double cost){
					
			this.cost = cost; 
		}
				
			final double cost; 
	} 

	private final Size size; 
	private final Cheese cheese; 
	private final ExtraTopping pineapple; 
	private final ExtraTopping greenpepper; 
	private final ExtraTopping ham; 
	
	public Pizza(Size size2, Cheese cheese2, ExtraTopping pineapple2, ExtraTopping greenpepper2, ExtraTopping ham2) throws IllegalPizza {
		
		if (size2 == null || cheese2 == null || pineapple2 == null || greenpepper2 == null || ham2 == null 
						  || (pineapple2 == ExtraTopping.Single && ham2 == ExtraTopping.None)
						  || (greenpepper2 == ExtraTopping.Single && ham2 == ExtraTopping.None)) {
			

			throw new IllegalPizza();
			
		}

		else {
			
			size = size2;
			cheese = cheese2;
			pineapple = pineapple2; 
			greenpepper = greenpepper2; 
			ham =  ham2; 
			

			/*size = Size.valueOf(size2); 
			cheese = Pizza.Cheese.valueOf(cheese2); 
			pineapple = Pizza.ExtraTopping.valueOf(pineapple2); 
			greenpepper = Pizza.ExtraTopping.valueOf(greenpepper2); 
			ham = ExtraTopping.valueOf(ham2); 
			*/
		}
	}
	
	
	public Pizza() {
		
		size = Size.Small; 
		cheese = Cheese.Single; 
		ham = ExtraTopping.Single; 
		pineapple = ExtraTopping.None; 
		greenpepper = ExtraTopping.None; 
	}
	
	
	public double getCost() {
		
		return size.cost + cheese.cost + pineapple.cost + greenpepper.cost + ham.cost; 
	}  
	
	
	public String toString() {
		
		DecimalFormat df = new DecimalFormat("#.00");
		String angleFormated = df.format(getCost());
		//System.out.println(angleFormated);
		String s = null;
		
		s = size.name() + " pizza, " + cheese.name() + " cheese" 
						+ ((pineapple == ExtraTopping.Single)? ", pineapple" : "") 
						+ ((greenpepper == ExtraTopping.Single)? ", green pepper" : "") 
						+ ((ham == ExtraTopping.Single)? ", ham" : "")
						+ ". Cost: " + "$" + angleFormated + " each."; 
		return s; 
	}
	
	
	public boolean equals(Object otherPizza){
		
		Pizza p; 
		if(otherPizza instanceof Pizza) {
			
			p = (Pizza) otherPizza; 
			if (size == p.size && cheese == p.cheese
							   && greenpepper == p.greenpepper
							   && pineapple == p.pineapple
							   && ham == p.ham) 
				
			{
				return true; 
			}
			
			else {
				
				return false;
			}			
		}
		
		else {
			
			return false; 
		}
	}
	
	public Pizza clone() {
		
		Pizza clone = null; 
		try {
			clone = new Pizza(size, cheese, greenpepper, pineapple, ham); 
		}
		
		catch (IllegalPizza e){
			
		}
		
		return clone; 
	}
}
