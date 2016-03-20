package seed.seyfer.autowiring.application;

public class ConsoleWriter implements LogWriter {
	public void write(String text) {
		System.out.println("write console " + text);
	}
}
