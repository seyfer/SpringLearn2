package seed.seyfer.annotationwiring.application;

public class FileWriter implements LogWriter {
	public void write(String text) {
		System.out.println("write file " + text);
	}
}
