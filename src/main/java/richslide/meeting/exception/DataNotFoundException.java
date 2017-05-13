package richslide.meeting.exception;

public class DataNotFoundException extends RSException {

	private static final long serialVersionUID = 8096653427413338217L;
	
	public DataNotFoundException() {};
	public DataNotFoundException(String msg) {super(msg);}
	public DataNotFoundException(String msg, Throwable t) {super(msg, t);}
	public DataNotFoundException(Throwable t) {super(t);}

}
