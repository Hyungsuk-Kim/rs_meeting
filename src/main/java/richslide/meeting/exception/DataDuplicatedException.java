package richslide.meeting.exception;

public class DataDuplicatedException extends RSException {

	private static final long serialVersionUID = 1132791745613130033L;
	
	public DataDuplicatedException() {};
	public DataDuplicatedException(String msg) {super(msg);}
	public DataDuplicatedException(String msg, Throwable t) {super(msg, t);}
	public DataDuplicatedException(Throwable t) {super(t);}

}
