package richslide.meeting.business.service;

import java.util.List;
import java.util.Map;

import richslide.meeting.business.dataaccess.BrainWritingDAO;
import richslide.meeting.business.domain.brainwriting.Idea;
import richslide.meeting.business.domain.brainwriting.MeetingRoom;
import richslide.meeting.business.domain.brainwriting.Session;
import richslide.meeting.business.domain.brainwriting.Sheet;
import richslide.meeting.business.domain.brainwriting.User;
import richslide.meeting.exception.DataDuplicatedException;
import richslide.meeting.exception.DataNotFoundException;

public class BrainWritingServiceImpl implements BrainWritingService {
	
	public BrainWritingServiceImpl(BrainWritingDAO dao) {
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createMeetingRoom(MeetingRoom room) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeMeetingRoom(MeetingRoom room) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addContributor(MeetingRoom room, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeContributor(MeetingRoom room, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createSession(Session session) throws DataDuplicatedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completeSession(Session session) throws DataNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveSession() throws DataNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSession(Session session) throws DataNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSession(Session session) throws DataNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Session> getSessionList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getSession(int sessionId) throws DataNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addContributor(Session session, User user) throws DataNotFoundException, DataDuplicatedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int completeRound(Session session, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nextRound(Session session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void initMeeting(MeetingRoom room) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addIdeaList(Sheet currSheet, List<Idea> ideaList, User author) {
		// TODO Auto-generated method stub
		
	}

	

}
