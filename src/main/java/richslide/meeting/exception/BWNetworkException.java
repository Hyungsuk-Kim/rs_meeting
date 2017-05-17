package richslide.meeting.exception;

public class BWNetworkException extends RSException {

	private static final long serialVersionUID = -6743496268451141733L;
	
	public BWNetworkException() {};
	public BWNetworkException(String msg) {super(msg);}
	public BWNetworkException(String msg, Throwable t) {super(msg, t);}
	public BWNetworkException(Throwable t) {super(t);}
	
}
