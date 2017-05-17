package richslide.meeting.network.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import richslide.meeting.exception.BWNetworkException;

public class BrainWritingClient {
	private String host;
    private int port;
    private Socket sock;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private int retry; // The number of count for try to connect server.
    
    public BrainWritingClient(String host, int port) throws BWNetworkException {
    	this.connect(host, port);
    }
    
    public void send(Object obj) throws BWNetworkException, InterruptedException {
        retry = 10;
        while (retry > 0) {
            try {
            	oos.writeObject(obj);
                retry = 0;
            } catch (Exception e) {
                retry--;
                if (retry == 0) {
                    throw new BWNetworkException("Connection failed.", e);
                }
                Thread.sleep(6000);
                connect();
            }
        }
    }
	
	public Object receive() throws Exception {
        Object obj = null;
        if (ois == null) {
            ois = new ObjectInputStream(sock.getInputStream());
        }
        if ((obj = ois.readObject()) == null){
        	throw new BWNetworkException("BrainWritingClient.receive failed : Missing Data.");
        }
        return obj;
    }
    
    public void connect(String host, int port) throws BWNetworkException {
    	this.host = host;
        this.port = port;
        this.connect();
    }

	private void connect() throws BWNetworkException {
		try {
            sock = new Socket(host, port);
            oos = new ObjectOutputStream(sock.getOutputStream());
        } catch(IOException e) {
        	throw new BWNetworkException(e.getMessage(), e);
        }
	}
	
	public void close() {
		if (sock != null) {
			try {
				sock.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
    }
}
