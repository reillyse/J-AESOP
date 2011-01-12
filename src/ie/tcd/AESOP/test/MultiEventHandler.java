package ie.tcd.AESOP.test;

/*
 * Class which represents a multi event handler
 * Has a listener which gets called in response to some events
 * The handler can react to multiple events
 * An execution policy is specified which decides when the handler gets called
 */
public abstract class MultiEventHandler {

	public MultiEventHandler() {

	}

	public abstract boolean executionPolicy();

	/*
	 * Handler is implemented by developer
	 */
	public abstract void handler();
}
