package richslide.meeting.exception;

public abstract class RSException extends Exception {

	private static final long serialVersionUID = -6351364992142338869L;
	
	public RSException() {};
	public RSException(String msg) {super(msg);}
	public RSException(String msg, Throwable t) {super(msg, t);}
	public RSException(Throwable t) {super(t);}
	
}
