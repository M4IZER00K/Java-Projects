
public class allSports {
	private String name;
	private int number;
	private int salary;
	private int stamina;
	
	public allSports(String name_input, int number_input, int salary_input, int stamina_input) {
		name = name_input;
		number = number_input;
		salary = salary_input;
		stamina = stamina_input;
	}
	
	public int getStamina() {
		return stamina;
	}
}
