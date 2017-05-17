package richslide.meeting.business.service;

import java.util.List;
import java.util.Map;

import richslide.meeting.business.dataaccess.BrainWritingDAO;
import richslide.meeting.business.domain.brainwriting.Session;
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
	public Session createSession(User master) throws DataDuplicatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void concludeSession(Session session) throws DataNotFoundException {
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
	public void removeContributor(Session session, User user) throws DataNotFoundException {
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

}
