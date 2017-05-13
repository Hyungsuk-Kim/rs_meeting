package richslide.meeting.business.service;

import java.util.List;
import java.util.Map;

import richslide.meeting.business.domain.brainwriting.*;
import richslide.meeting.exception.DataDuplicatedException;
import richslide.meeting.exception.DataNotFoundException;

public interface BrainWritingService {
	
	public static final int COMPLETE_SAVE_ROUND_SUCCESS_CODE = 101;
	public static final int COMPLETE_SAVE_ROUND_FAILURE_CODE = 100;
	public static final int COMPLETE_LOAD_NEXT_ROUND_SUCCESS_CODE = 201;
	public static final int COMPLETE_LOAD_NEXR_ROUND_FAILURE_CODE = 200;
	
	public void init();
	public Session createSession(User master) throws DataDuplicatedException;
	public void concludeSession(Session session) throws DataNotFoundException;
	public List<Session> getSessionList(Map<String, Object> params);
	public Session getSession(int sessionId) throws DataNotFoundException;
	public void addContributor(Session session, User user) throws DataNotFoundException, DataDuplicatedException; 
	public void removeContributor(Session session, User user) throws DataNotFoundException;
	public int completeRound(Session session, User user);
	public int nextRound(Session session);
}
