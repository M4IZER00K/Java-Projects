
public class Basketball extends allSports{
	private double verticle;
	private double freeThrowPercentage;
	private double threePointPercentage;
	
	public Basketball(String name_input, int number_input, int salary_input, int stamina_input, double inputVerticle, double inputFreeThrowPercentage, double inputThreePointPercentage) {
		super(name_input, number_input, salary_input, stamina_input);
		verticle = inputVerticle;
		freeThrowPercentage = inputFreeThrowPercentage;
		threePointPercentage = inputThreePointPercentage;
	}
	
	public double getVerticle() {
		return verticle; 
	}
}
