package richslide.meeting.business.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import richslide.meeting.business.domain.brainwriting.Idea;
import richslide.meeting.business.domain.brainwriting.Session;
import richslide.meeting.business.domain.brainwriting.Sheet;
import richslide.meeting.business.domain.brainwriting.User;

public class BrainWritingDAOImpl implements BrainWritingDAO {
	
	String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/MiniProject";
    String user = "root";
    String password = "1234";
	
    public BrainWritingDAOImpl() {
        try {
        	Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    protected Connection obtainConnection() throws SQLException {
    	return DriverManager.getConnection(url, user, password);
    }

	@Override
	public int insertSession(Session session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSession(Session session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSession(Session session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Session selectSession(int sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Session> selectSessionList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertSheet(Sheet sheet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSheet(Sheet sheet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSheet(Sheet sheet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sheet selectSheet(String sheetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sheet> selectSheetListBySessionId(int sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sheet> selectSheetListByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertIdea(Idea idea) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateIdea(Idea idea) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteIdea(Idea idea) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Idea selectIdea(int ideaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Idea> selectIdeaListBySheetId(String sheetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Idea> selectIdeaListByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
