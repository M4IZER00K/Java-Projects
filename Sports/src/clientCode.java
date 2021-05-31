
public class clientCode {
	public static void main(String[] args) {
		Baseball BabeRuth = new Baseball("Babe Ruth", 3, 500000, 40, 105, false, true);
		System.out.println("Thier ball speed is: " + BabeRuth.getBallSpeed() + " and his stamina was: " + BabeRuth.getStamina());
		
		Football TyreekHill = new Football("Tyreek Hill", 10, 18000000, 90);
		TyreekHill.setFootballStats(4.29, 10, 40.5, 129);
		System.out.println("Tyreek Hill's verticle is: " + TyreekHill.getVerticle());	
	}
}
