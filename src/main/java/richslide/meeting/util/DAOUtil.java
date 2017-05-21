package richslide.meeting.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.StringTokenizer;

import richslide.meeting.common.CommonConst;

public class DAOUtil {
	
	public static final String url = "jdbc:mysql://"+CommonConst.DB_HOST+":3306/"+CommonConst.DB_SCHEME_NAME;
	public static final String user = CommonConst.DB_USER;
	public static final String password = CommonConst.DB_PASSWORD;
	
	static {
		try {
        	Class.forName(CommonConst.DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public static Connection obtainConnection() throws SQLException {
    	return DriverManager.getConnection(url, user, password);
    }
	
	public static String convertColumnNameToVariableName(String colName) {
		char[] variableName = colName.toCharArray();
		
		for (int i = 0; i < variableName.length; i++) {
			if ('_' == variableName[i]) {
				variableName[i] += 32; // to upper case
				System.arraycopy(variableName, i+1, variableName, i, variableName.length);
			}
		}
		
		return String.valueOf(variableName).trim();
	}
	
	public static String convertVariableNameToColumnName(String variableName) {
		StringBuilder builder = new StringBuilder();
		for (char c : variableName.toCharArray()) {
			if (c > 31 && c < 91) {
				builder.append('_');
				c -= 32; // to lower case
			}
			builder.append(c);
		}
		return builder.toString();
	}
	
	public static String toStringColumnList(String[] cols) {
		StringBuilder builder = new StringBuilder();
		for (String col : cols) {
			builder.append(col);
			builder.append(",");
		}
		return builder.deleteCharAt(builder.length() - 1).toString();
	}
	
	public static String updateQueryStringExceptWhereCondition(String[] cols, String tableName) {
		StringBuilder query = new StringBuilder("UPDATE " + tableName + " SET ");
		for (int i = 0; i < cols.length; i++) {
			if (i == cols.length - 1) {
				query.append(cols[i] + " = ?");
			} else {
				query.append(cols[i] + " = ?, ");
			}
		}
		return null;
	}
	
	public static String deleteByPKQueryString(String colName_pk, String tableName) {
		return "DELETE FROM " + tableName + " WHERE " + colName_pk + " = ?";
	}
	
	public static String insertQueryString(String[] cols, String tableName) {
		StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (");
		query.append(toStringColumnList(cols));
		query.append(") VALUES (");
		for (int i = 0; i < cols.length; i++) {
			if (i == cols.length - 1) {
				query.append("?)");
			} else {
				query.append("?,");
			}
		}
		return query.toString();
	}
	
	public static String queryStringByMap(Map<String, Object> map, String key) {
		StringTokenizer token = new StringTokenizer(key, "_");
		String action = token.nextToken();
		String tableName = token.nextToken();
		Object value = map.get(key);
		String query = null;
		
		switch (action) {
		case "insert":
			query = insertQueryString((String[]) value, tableName);
			break;
			
		case "update":
			query = updateQueryStringExceptWhereCondition((String[]) value, tableName);
			break;
			
		case "delete":
			query = deleteByPKQueryString((String) value, tableName);
			break;
			
		default:
			break;
		}
		return query;
	}
}
