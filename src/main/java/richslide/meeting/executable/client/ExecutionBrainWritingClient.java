package richslide.meeting.executable.client;

import java.util.StringTokenizer;

import richslide.meeting.business.service.BrainWritingService;
import richslide.meeting.common.CommonConst;
import richslide.meeting.exception.BWNetworkException;
import richslide.meeting.network.client.BrainWritingClient;
import richslide.meeting.network.service.BrainWritingNWService;
import richslide.meeting.gui.BrainWritingGUI;

public class ExecutionBrainWritingClient {
	
	public static void main(String[] args) {
		
		String host = "localhost";
		String port = String.valueOf(CommonConst.DEFAULT_SERVICE_PORT);
		
		if (args.length > 1) {
			host = args[0];
			port = args[1];
		} else if (args.length == 1) {
			StringTokenizer token = new StringTokenizer(args[0], ":");
			host = token.nextToken();
			port = token.nextToken();
		} else {}
		
		BrainWritingService service;
		try {
			service = new BrainWritingNWService(new BrainWritingClient(host, Integer.parseInt(port)));
			new BrainWritingGUI(service);
		} catch (NumberFormatException | BWNetworkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
