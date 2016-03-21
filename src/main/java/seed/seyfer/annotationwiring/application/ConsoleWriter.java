package seed.seyfer.annotationwiring.application;

import org.springframework.stereotype.Component;

@Component("consolewriter")
public class ConsoleWriter implements LogWriter {
	public void write(String text) {
		System.out.println("write console " + text);
	}
}
