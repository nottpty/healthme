package absi;

public class Main {
	public static void main(String[] args) {
		Absi absi = new Absi();
		absi.setInfo("Male", 21, 183, 80, 83.82);
		absi.findZscore();
		System.out.println("ABSI : "+absi.getValue());
		System.out.println("Z Score : "+absi.getZscore());
		System.out.println("Mortality risk : "+absi.getMortalityRisk());
	}
}
