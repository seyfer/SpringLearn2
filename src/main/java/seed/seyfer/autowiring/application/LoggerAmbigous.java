package seed.seyfer.autowiring.application;

public class LoggerAmbigous {
	private LogWriter consoleWriter;
	private LogWriter fileWriter;

	public LoggerAmbigous() {
		super();
	}

	public LoggerAmbigous(ConsoleWriter consoleWriter, FileWriter fileWriter) {
		super();
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}

	public void setConsoleWriter(LogWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		consoleWriter.write(text);
	}

}
