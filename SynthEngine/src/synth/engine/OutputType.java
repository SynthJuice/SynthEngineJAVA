package synth.engine;

public enum OutputType {
	entityCreation(true),
	entityMessage(true),
	warning(true),
	note(true),
	debug(true);

	public boolean allow;
	private OutputType(boolean allow) {
		this.allow = allow;
	}
}
