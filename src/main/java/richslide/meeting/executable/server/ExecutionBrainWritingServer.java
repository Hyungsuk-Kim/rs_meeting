package richslide.meeting.executable.server;

import richslide.meeting.business.dataaccess.BrainWritingDAOImpl;
import richslide.meeting.business.service.BrainWritingServiceImpl;
import richslide.meeting.common.CommonConst;
import richslide.meeting.exception.BWNetworkException;
import richslide.meeting.network.server.BrainWritingServer;

public class ExecutionBrainWritingServer {
	
	public static void main(String[] args) {
		int port = CommonConst.DEFAULT_SERVICE_PORT;
		
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		
		try {
			new BrainWritingServer(port, new BrainWritingServiceImpl(new BrainWritingDAOImpl()));
		} catch (BWNetworkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
