package richslide.meeting.gui.views;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

import richslide.meeting.business.domain.brainwriting.MeetingRoom;
import richslide.meeting.business.domain.brainwriting.User;

public class WaitRoom {

	private JFrame frame = new JFrame("대기실");
	private JLabel rooms, waiter, label; // 대화방, 대기자, 레이블 변수
	private JTabbedPane tabs;
	private JList<MeetingRoom> roomInfo; // 대화방 리스트, 대기자 리스트 변수
	private JList<User> waiterInfo; // 대화방 리스트, 대기자 리스트 변수
	private JButton create, join, sendword, logout; //회의방 개설, 회의방 참여, 귓말보내기, 로그아웃 버튼 변수
	private Font font; // 글꼴 변수
	private JViewport view; //
	private JScrollPane jsp3; // 스크롤바 변수
	private JTextArea outputMsgs; // 출력창 변수
	private JTextField inputText; // 텍스트 입력 변수
	
	private void buildDisplay() {
		
		this.font = new Font("SanSerif", Font.PLAIN, 12); //글꼴 지정(SanSerif 글씨체, 표준체, 12pt)
		
		roomInfo = new JList<MeetingRoom>();
		frame.add(roomInfo);
	}
}
