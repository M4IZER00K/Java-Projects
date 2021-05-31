
public class Football extends allSports{
	private String name;
	private int number;
	private int salary;
	private int stamina;
	
	private double yarddash40;
	private int benchpresses;
	private double verticle;
	private double broadjump;
	
	
	public Football(String name_input, int number_input, int salary_input, int stamina_input) {
		super(name_input, number_input, salary_input, stamina_input);
		name = name_input;
		number = number_input;
		salary = salary_input;
		stamina = stamina_input; 
	}
	
	public void setFootballStats(double inputYard, int bench, double verticle_input, double broads) {
		yarddash40 = inputYard;
		benchpresses = bench;
		verticle = verticle_input;
		broadjump = broads;
	}
	
	public double getVerticle() {
		return verticle;
	}
}
