

	
	import java.util.Scanner;

	// Abstract class Food
	abstract class Food {
	    double proteins;
	    double fats;
	    double carbs;
	    double tastyScore;

	    // Abstract method getMacroNutrients
	    abstract void getMacroNutrients();
	}

	// Class Egg extending Food
	class Egg extends Food {
	    int tastyScore = 7;
	    String type = "non-vegetarian";

	    // Constructor to initialize attributes
	    public Egg(double proteins, double fats, double carbs) {
	        this.proteins = proteins;
	        this.fats = fats;
	        this.carbs = carbs;
	    }

	    // Implementing the abstract method
	    void getMacroNutrients() {
	        System.out.println("An egg has " + this.proteins + " gms of protein, " + this.fats + " gms of fats and " + this.carbs + " gms of carbohydrates.");
	    }
	}

	// Class Bread extending Food
	class Bread extends Food {
	    int tastyScore = 8;
	    String type = "vegetarian";

	    // Constructor to initialize attributes
	    public Bread(double proteins, double fats, double carbs) {
	        this.proteins = proteins;
	        this.fats = fats;
	        this.carbs = carbs;
	    }

	    // Implementing the abstract method
	    void getMacroNutrients() {
	        System.out.println("A slice of bread has " + this.proteins + " gms of protein, " + this.fats + " gms of fats and " + this.carbs + " gms of carbohydrates.");
	    }
	}


