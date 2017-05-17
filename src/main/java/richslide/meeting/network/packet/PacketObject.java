package richslide.meeting.network.packet;

import java.io.Serializable;

import richslide.meeting.business.service.BrainWritingService;

public abstract class PacketObject implements Serializable {
	
	private static final long serialVersionUID = -3530658806179458373L;
	
	private Object result;
	private Exception exception;

	/** Using Server`s model implementation,
	 * this method called when receive this packet object from ObjectInputStream connected to Client side.
	 */
	public abstract void execute(BrainWritingService service);
	
	/** Using Client`s model implementation, 
	 * this method called when receive this packet object from ObjectInputStream connected to Server side.
	 */
	public Object getResult() throws Exception {
        if (this.exception != null) {
            throw this.exception;
        }
        return this.result;
    }
}
