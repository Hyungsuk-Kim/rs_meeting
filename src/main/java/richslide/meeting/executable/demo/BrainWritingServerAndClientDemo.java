package richslide.meeting.executable.demo;

import java.util.StringTokenizer;

import richslide.meeting.business.service.BrainWritingService;
import richslide.meeting.common.CommonConst;
import richslide.meeting.exception.BWNetworkException;
import richslide.meeting.executable.server.ExecutionBrainWritingServer;
import richslide.meeting.network.client.BrainWritingClient;
import richslide.meeting.network.service.BrainWritingNWService;
import richslide.meeting.gui.BrainWritingGUI;

public class BrainWritingServerAndClientDemo {
	
	private String host = "localhost";
	private int port = CommonConst.DEFAULT_SERVICE_PORT;
	
	public BrainWritingServerAndClientDemo() {
		this.executeServer();
	}
	
	public BrainWritingServerAndClientDemo(String host, String port) {
		this.host = host;
		this.port = Integer.parseInt(port);
		this.executeServer();
	}
	
	public BrainWritingServerAndClientDemo(String host) {
		StringTokenizer token = new StringTokenizer(host, ":");
		this.host = token.nextToken();
		this.port = Integer.parseInt(token.nextToken());
		this.executeServer();
	}
	
	private void executeServer() {
		ExecutionBrainWritingServer.main(new String[] {String.valueOf(this.port)});
		this.excuteClient();
	}
	
	private void excuteClient() {
		try {
			BrainWritingService service = new BrainWritingNWService(new BrainWritingClient(this.host, this.port));
			new BrainWritingGUI(service);
		} catch (BWNetworkException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		if (args.length > 1) {
			new BrainWritingServerAndClientDemo(args[0], args[1]);
		} else if (args.length == 1) {
			new BrainWritingServerAndClientDemo(args[0]);
		} else {
			new BrainWritingServerAndClientDemo();
		}
		
	}
}
