
public class Baseball extends allSports {
	private String name;
	private int number;
	private int salary;
	private int stamina;
	
	private int ballSpeed;
	private boolean pitcher;
	private boolean batter;
	
	public Baseball(String name_input, int number_input, int salary_input, int stamina_input, int ballSpeed_input, boolean pitcher_input, boolean batter_input) {
		super(name_input, number_input, salary_input, stamina_input);
		name = name_input;
		number = number_input;
		salary = salary_input;
		stamina = stamina_input;
		ballSpeed = ballSpeed_input;
		pitcher = pitcher_input;
		batter = batter_input;
	}
	
	public double getBallSpeed(){
		return ballSpeed;
	}
	
}
