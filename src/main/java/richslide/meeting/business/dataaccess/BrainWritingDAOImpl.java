package richslide.meeting.business.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
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
	
	private static final String INSERT_SESSION_KEY = "insert/session";
	private static final String UPDATE_SESSION_KEY = "update/session/session_id";
	private static final String REMOVE_SESSION_KEY = "update/session/session_id";
	private static final String DELETE_SESSION_KEY = "delete/session";
	private static final String INSERT_SHEET_KEY = "insert/sheet";
	//private static final String UPDATE_SHEET_KEY = "update/sheet";
	private static final String DELETE_SHEET_KEY = "delete/sheet";
	private static final String INSERT_IDEA_KEY = "insert/idea";
	private static final String UPDATE_IDEA_KEY = "update/idea/idea_id";
	private static final String DELETE_IDEA_KEY = "delete/idea";
	private static final String INSERT_CONTRIBUTOR_KEY = "insert/contributor";
	//private static final String UPDATE_CONTRIBUTOR_KEY = "update/contributor";
	private static final String DELETE_CONTRIBUTOR_KEY = "delete/contributor";
	
	private static final String[] SESSION_INSERT_COLS = {"subject", "master_id", "start_time", "end_time", "time_per_round", "suggestion_count", "exposure", "del_flag"};
	private static final String[] SESSION_UPDATE_COLS = {"subject", "start_time", "end_time", "time_per_round", "suggestion_count", "exposure"};
	private static final String[] SESSION_REMOVE_COLS = {"del_flag"};
	private static final String[] SESSION_DELETE_PK = {"session_id"};
	private static final String[] SHEET_INSERT_COLS = {"sheet_id", "owner_id", "session_id"};
	//private static final String[] SHEET_UPDATE_COLS = {};
	private static final String[] SHEET_DELETE_PK = {"sheet_id"};
	private static final String[] IDEA_INSERT_COLS = {"sheet_id", "author_id", "content"};
	private static final String[] IDEA_UPDATE_COLS = {"content"};
	private static final String[] IDEA_DELETE_PK = {"idea_id"};
	private static final String[] CONTRIBUTOR_INSERT_COLS = {"session_id", "user_id"};
	//private static final String[] CONTRIBUTOR_UPDATE_COLS = {};
	private static final String[] CONTRIBUTOR_DELETE_PK = {"session_id", "user_id"};
    
    private Map<String, Object> columnPreSet = new HashMap<String, Object>();
    
    {
    	String[] keyArr = {INSERT_SESSION_KEY, UPDATE_SESSION_KEY, DELETE_SESSION_KEY, REMOVE_SESSION_KEY,
    			INSERT_SHEET_KEY, /*UPDATE_SHEET_KEY,*/ DELETE_SHEET_KEY,
    			INSERT_IDEA_KEY, UPDATE_IDEA_KEY, DELETE_IDEA_KEY,
    			INSERT_CONTRIBUTOR_KEY, /*UPDATE_CONTRIBUTOR_KEY,*/ DELETE_CONTRIBUTOR_KEY
    	};
    	Object[] valueArr = {SESSION_INSERT_COLS, SESSION_UPDATE_COLS, SESSION_DELETE_PK, SESSION_REMOVE_COLS,
    			SHEET_INSERT_COLS, /*SHEET_UPDATE_COLS,*/ SHEET_DELETE_PK,
    			IDEA_INSERT_COLS, IDEA_UPDATE_COLS, IDEA_DELETE_PK,
    			CONTRIBUTOR_INSERT_COLS, /*CONTRIBUTOR_UPDATE_COLS,*/ CONTRIBUTOR_DELETE_PK
    	};
    	
    	for (int i = 0 ; i < keyArr.length; i++) {
    		columnPreSet.put(keyArr[i], valueArr[i]);
    	}
    }
    
    public BrainWritingDAOImpl() {}
	
	private String callQueryStringMethodByMap(String key) {
		return DAOUtil.queryStringByMap(this.columnPreSet, key);
	}
    
	private int insertSession(Session session, Connection conn) throws Exception {
		String sql = this.callQueryStringMethodByMap(INSERT_SESSION_KEY);
		int affectedRows = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			conn.setAutoCommit(false);
			Savepoint sp = conn.setSavepoint();
			
			// Set Parameters on PreparedStatement query.
			pstmt.setString(1, session.getSubject());
			pstmt.setString(2, session.getMaster().getUserName());
			pstmt.setTimestamp(3, session.getStartTime());
			pstmt.setTimestamp(4, session.getEndTime());
			pstmt.setLong(5, session.getTimePerRound());
			pstmt.setInt(6, session.getSuggestionCount());
			pstmt.setInt(7, session.getExposure());
			pstmt.setInt(8, Session.ENABLE_SESSION);
			
			affectedRows = pstmt.executeUpdate();
			
			List<User> contributors = session.getContributors();
			if (!(contributors == null || contributors.isEmpty())) {
				// insert contributors
				for (User user : contributors) {
					
				}
			}
			
			List<Sheet> sheets = session.getSheets();
			if (!(sheets == null || sheets.isEmpty())) {
				for (Sheet sheet : sheets) {
					
					List<Idea> ideaSet = sheet.getIdeaSetPerPerson();
					if (!(ideaSet == null || ideaSet.isEmpty())) {
						
					}
				}
			}
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (Exception e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		} finally {
			try { if (pstmt != null) pstmt.close(); } catch(SQLException ex) { ex.printStackTrace(System.err); }
			try { if (conn != null) conn.close(); } catch(SQLException ex){ ex.printStackTrace(System.err); }
		}
		
		return affectedRows;
	}

	@Override
	public int insertSession(Session session) {
		int result = 0;
		try {
			result = this.insertSession(session, DAOUtil.obtainConnection());
		} catch (Exception e) {e.printStackTrace();}
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
	public Sheet selectSheet(String sheetId, int sessionId) {
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
	public int insertIdea(Idea idea, Sheet currSheet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateIdea(Idea idea, Sheet currSheet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteIdea(Idea idea, Sheet currSheet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Idea selectIdea(int ideaId, String sheetId, int sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Idea> selectIdeaListBySheetId(String sheetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Idea> selectIdeaListByUser(User user, int sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectContributorList(int sessionId) {
		// TODO Auto-generated method stub
		return null;
	}
	private List<User> selectContributorList(int sessionId, Connection conn) throws Exception {
		List<User> contributors = new ArrayList<User>();
		String sql = "SELECT session_id, user_id FROM _contributor WHERE session_id = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sessionId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// TODO get User Instance
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				contributors.add(user);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try { if (pstmt != null) pstmt.close(); } catch(SQLException ex) { ex.printStackTrace(System.err); }
			try { if (conn != null) conn.close(); } catch(SQLException ex){ ex.printStackTrace(System.err); }
		}
		
		return contributors;
	}

	@Override
	public int insertContributor(User user, int sessionId) {
		int result = 0;
		try {
			this.insertContributor(user, sessionId, DAOUtil.obtainConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private int  insertContributor(User user, int sessionId, Connection conn) throws Exception {
		String sql = this.callQueryStringMethodByMap(INSERT_CONTRIBUTOR_KEY);
		int affectedRows = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sessionId);
			pstmt.setInt(2, user.getUserId());
			
			affectedRows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			try { if (pstmt != null) pstmt.close(); } catch(SQLException ex) { ex.printStackTrace(System.err); }
			try { if (conn != null) conn.close(); } catch(SQLException ex){ ex.printStackTrace(System.err); }
		}
		
		return affectedRows;
	}

	@Override
	public int updateContributor(User user, int sessionId) {
		int result = 0;
		try {
			result = this.updateContributor(user, sessionId, DAOUtil.obtainConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private int updateContributor(User user, int sessionId, Connection conn) {
		// TODO 
		return 0;
	}

	@Override
	public int deleteContributor(User user, int sessionId) {
		int result = 0;
		try {
			result = this.deleteContributor(user, sessionId, DAOUtil.obtainConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private int  deleteContributor(User user, int sessionId, Connection conn) throws Exception {
		String sql = this.callQueryStringMethodByMap(DELETE_CONTRIBUTOR_KEY);
		int affectedRows = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sessionId);
			pstmt.setInt(2, user.getUserId());
			
			affectedRows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			try { if (pstmt != null) pstmt.close(); } catch(SQLException ex) { ex.printStackTrace(System.err); }
			try { if (conn != null) conn.close(); } catch(SQLException ex){ ex.printStackTrace(System.err); }
		}
		
		return affectedRows;
	}
}
