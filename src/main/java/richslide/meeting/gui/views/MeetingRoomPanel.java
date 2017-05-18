package richslide.meeting.gui.views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import richslide.meeting.business.controller.BrainWritingController;
import richslide.meeting.business.service.BrainWritingService;

public class MeetingRoomPanel implements BWPanel {
	
	private BrainWritingController controller;
	private BrainWritingService service;
	
	protected JLabel lblMeetingRoom = new JLabel("회의실 리스트", SwingConstants.CENTER);
	protected JPanel roomPan = new JPanel();
	protected DefaultTableModel tableModel;
	protected JTable table;
	protected JScrollPane tablePane;
	
	protected void buildDisplay() {
		roomPan.setLayout(new BorderLayout());
		
		tableModel = new DefaultTableModel();
    	table = new JTable(tableModel);
    	tablePane = new JScrollPane(table);
        
    	roomPan.add(lblMeetingRoom, BorderLayout.NORTH);
    	roomPan.add(table, BorderLayout.CENTER);
        
        Dimension dim = new Dimension(500, 150);
        table.setPreferredScrollableViewportSize(dim);
	}

	@Override
	public void registerController(BrainWritingController controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return null;
	}

}
