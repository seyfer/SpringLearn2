package seed.seyfer.annotationwiring.application;

import org.springframework.beans.factory.annotation.Autowired;

public class Logger {
	
	@Autowired
	private ConsoleWriter consoleWriter;
	
	@Autowired
	private FileWriter fileWriter;

	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		consoleWriter.write(text);
	}

}
