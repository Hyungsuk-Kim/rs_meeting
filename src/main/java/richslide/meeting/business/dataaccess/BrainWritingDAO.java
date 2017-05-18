package richslide.meeting.business.dataaccess;

import java.util.List;
import java.util.Map;

import richslide.meeting.business.domain.brainwriting.*;

public interface BrainWritingDAO {
	public int insertSession(Session session);
	public int updateSession(Session session);
	public int deleteSession(Session session);
	public Session selectSession(int sessionId);
	public List<Session> selectSessionList(Map<String, Object> params);
	
	public int insertSheet(Sheet sheet);
	public int updateSheet(Sheet sheet);
	public int deleteSheet(Sheet sheet);
	public Sheet selectSheet(String sheetId);
	public List<Sheet> selectSheetListBySessionId(int sessionId);
	public List<Sheet> selectSheetListByUser(User user);
	
	public int insertIdea(Idea idea);
	public int updateIdea(Idea idea);
	public int deleteIdea(Idea idea);
	public Idea selectIdea(int ideaId);
	public List<Idea> selectIdeaListBySheetId(String sheetId);
	public List<Idea> selectIdeaListByUser(User user);
}
