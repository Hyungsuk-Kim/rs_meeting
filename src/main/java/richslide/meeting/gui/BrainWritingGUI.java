package richslide.meeting.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import richslide.meeting.business.controller.BrainWritingController;
import richslide.meeting.business.domain.brainwriting.Session;
import richslide.meeting.business.service.BrainWritingService;

public class BrainWritingGUI {

	private BrainWritingController controller;
	private BrainWritingService service;
	
	private Session session;
	
	protected JFrame frame;
	protected JPanel viewPanel;
	
	public BrainWritingGUI(BrainWritingService service) {
		this.service = service;
        buildDisplay();
	}
	
	public void setController(BrainWritingController controller) {
		this.controller = controller;
		
	}
	
	protected void buildDisplay() {
		
	}
}
