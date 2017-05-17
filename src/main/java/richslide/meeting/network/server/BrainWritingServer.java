package richslide.meeting.network.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import richslide.meeting.business.service.BrainWritingService;
import richslide.meeting.exception.BWNetworkException;
import richslide.meeting.network.packet.PacketObject;

public class BrainWritingServer {
	private ServerSocket serverSocket;
	private BrainWritingService service;
	
	public BrainWritingServer(int port, BrainWritingService service) throws BWNetworkException {
		
		try {
			this.serverSocket = new ServerSocket(port);
			this.acceptConnection();
		} catch (IOException e) {
			throw new BWNetworkException(e.getMessage(), e);
		}
	}
	
	private void acceptConnection() {
		Socket sock;
        System.out.println("Server is listening");
        while (true) {
            try {
            	while (true) {
            		sock = serverSocket.accept();
            		new ThreadAllocatedPerClient(this, sock).start();
            	}
            } catch (Exception e) {
                System.out.println("Server.acceptConnection: " + e);
            }
        }
	}
	
	class ThreadAllocatedPerClient extends Thread {
		
		private BrainWritingServer server;
    	private Socket socket;
    	private ObjectInputStream ois;
    	private ObjectOutputStream oos;
    	
		public ThreadAllocatedPerClient(BrainWritingServer bwServer, Socket sock) {
			this.server = bwServer;
    		this.socket = sock;
		}

		@Override
    	public void run() {
    		
    		PacketObject packet = null;
            try {
                ois = new ObjectInputStream(socket.getInputStream());
                oos = new ObjectOutputStream(socket.getOutputStream());
                while (true) {
                	packet = (PacketObject) ois.readObject();
                    packet.execute(this.server.service);
                    
                    oos.writeObject(packet);
                }
            } catch (Exception e) {
            	e.printStackTrace();
            	//throw new BWNetworkException(e.getMessage(), e);
            } finally {
            	try {
	            	if (ois != null) {
	            		ois.close();
	            	}
	            	if (oos != null) {
	            		oos.close();
	            	}
	            	if (socket != null) {
	            		socket.close();
	            	}
            	} catch (IOException e) {
            		e.printStackTrace();
            	}
            }
    	}
	}
}
