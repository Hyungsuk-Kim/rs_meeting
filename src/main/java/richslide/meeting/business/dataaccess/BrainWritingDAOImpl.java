package richslide.meeting.business.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import richslide.meeting.business.domain.brainwriting.Idea;
import richslide.meeting.business.domain.brainwriting.Session;
import richslide.meeting.business.domain.brainwriting.Sheet;
import richslide.meeting.business.domain.brainwriting.User;
import richslide.meeting.common.CommonConst;
import richslide.meeting.util.DAOUtil;

public class BrainWritingDAOImpl implements BrainWritingDAO {
	
	private static final String INSERT_SESSION_KEY = "insert_session";
	private static final String UPDATE_SESSION_KEY = "update_session";
	private static final String DELETE_SESSION_KEY = "delete_session";
	
	private static final String[] SESSION_INSERT_COLS = {"subject", "master_id", "start_time", "end_time", "time_per_round", "suggestion_count", "exposure", "del_flag"};
	private static final String[] SESSION_UPDATE_COLS = {};
	private static final String SESSION_DELETE_PK = "session_id";
    
    private Map<String, Object> columnPreSet = new HashMap<String, Object>();
    
    {
    	String[] keyArr = {INSERT_SESSION_KEY, UPDATE_SESSION_KEY, DELETE_SESSION_KEY};
    	Object[] valueArr = {SESSION_INSERT_COLS, SESSION_UPDATE_COLS, SESSION_DELETE_PK};
    	
    	for (int i = 0 ; i < keyArr.length; i++) {
    		columnPreSet.put(keyArr[i], valueArr[i]);
    	}
    }
    
    public BrainWritingDAOImpl() {}
    
	@Override
	public int insertSession(Session session) {
		String sql = this.callQueryStringMethodByMap(INSERT_SESSION_KEY);
		int result = 0;
		
		Connection conn;
		PreparedStatement pstmt;
		
		
		try {
			conn = DAOUtil.obtainConnection();
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		return result;
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
	
	private String callQueryStringMethodByMap(String key) {
		return DAOUtil.queryStringByMap(this.columnPreSet, key);
	}
}
