package richslide.meeting.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
		return query.toString();
	}
	
	public static String updateQueryString(String[] cols, String tableName, String[] pks) {
		StringBuilder query = new StringBuilder("UPDATE " + tableName + " SET ");
		for (int i = 0; i < cols.length; i++) {
			if (i == cols.length - 1) {
				query.append(cols[i] + " = ? WHERE ");
			} else {
				query.append(cols[i] + " = ?, ");
			}
		}
		for (int i = 0; i < pks.length; i++) {
			if (i == pks.length - 1) {
				query.append(pks[i] + " = ?");
			} else {
				query.append(pks[i] + " = ?, ");
			}
		}
		return query.toString();
	}
	
	public static String deleteByPKQueryString(String[] colName_pk, String tableName) {
		StringBuilder query = new StringBuilder("DELETE FROM " + tableName + " WHERE ");
		for (String colName : colName_pk) {
			query.append(colName + " = ?");
			query.append(",");
		}
		return query.deleteCharAt(query.length() - 1).toString();
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
		StringTokenizer token = new StringTokenizer(key, "/");
		String action = token.nextToken();
		String tableName = "_" + token.nextToken();
		Object value = map.get(key);
		String query = null;
		
		switch (action) {
		case "insert":
			query = insertQueryString((String[]) value, tableName);
			break;
			
		case "update":
			List<String> pks = new ArrayList<String>();
			while (token.hasMoreTokens()) {
				pks.add(token.nextToken());
			}
			if (pks.isEmpty()) {
				query = updateQueryStringExceptWhereCondition((String[]) value, tableName);
			} else {
				query = updateQueryString((String[]) value, tableName, pks.toArray(new String[0]));
			}
			break;
			
		case "delete":
			query = deleteByPKQueryString((String[]) value, tableName);
			break;
			
		default:
			break;
		}
		return query;
	}
}
