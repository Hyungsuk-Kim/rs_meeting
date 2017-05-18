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
import richslide.meeting.business.domain.brainwriting.Session;
import richslide.meeting.business.service.BrainWritingService;

public class SessionPanel implements BWPanel {
	
	private BrainWritingController controller;
	private BrainWritingService service;
	
	protected JLabel lblSession = new JLabel("완료된 세션 리스트", SwingConstants.CENTER);
	protected JPanel sessionPan = new JPanel();
	protected DefaultTableModel tableModel;
	protected JTable table;
	protected JScrollPane tablePane;
	
	protected void buildDisplay() {
		sessionPan.setLayout(new BorderLayout());
		
		tableModel = new DefaultTableModel();
    	table = new JTable(tableModel);
    	tablePane = new JScrollPane(table);
        
        sessionPan.add(lblSession, BorderLayout.NORTH);
        sessionPan.add(table, BorderLayout.CENTER);
        
        Dimension dim = new Dimension(500, 150);
        table.setPreferredScrollableViewportSize(dim);
	}

	@Override
	public void registerController(BrainWritingController controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(Object obj) {
		if (obj instanceof Session[]) {
			
		}
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
