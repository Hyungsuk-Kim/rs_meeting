package richslide.meeting.gui.views;

import javax.swing.JPanel;

import richslide.meeting.business.controller.BrainWritingController;


public interface BWPanel {
	void registerController(BrainWritingController controller);

    void display(Object obj);

    void refresh();

    JPanel getPanel();
}
