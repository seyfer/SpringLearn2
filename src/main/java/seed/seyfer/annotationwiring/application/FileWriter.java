package seed.seyfer.annotationwiring.application;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("filewriter")
@Component("filewriter")
public class FileWriter implements LogWriter {
	public void write(String text) {
		System.out.println("write file " + text);
	}
}
