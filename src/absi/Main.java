package absi;

public class Main {
	public static void main(String[] args) {
		Absi absi = new Absi();
		AbsiUI absiUI = new AbsiUI(absi);
		absi.addObserver(absiUI);
		absiUI.run();
	}
}
