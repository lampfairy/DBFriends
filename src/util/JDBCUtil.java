package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;

public class JDBCUtil {
	private String sql = null; // 실행할 query
	private Object[] parameters = null;; // PreparedStatement 의 매개변수 값을 저장하는 배열
	private static DataSource ds = null; // DBCP DataSource
	private static Connection conn = null;
	private PreparedStatement pstmt = null;
	private CallableStatement cstmt = null;
	private ResultSet rs = null;

	private static Properties prop = new Properties();
	{
		InputStream input = null;
		try {
			input = getClass().getResourceAsStream("dbinfo.properties");
			prop.load(input);			// load the properties file
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
	}

	// DBCP 연결 초기화 메소드
	private static void initJDBCUtil() {		
		try {
			if (ds == null) { // DBCP 설정
				BasicDataSource bds = new BasicDataSource();
				bds.setDriverClassName(prop.getProperty("db.driver"));
		        bds.setUrl(prop.getProperty("db.url"));
		        bds.setUsername(prop.getProperty("db.username"));
		        bds.setPassword(prop.getProperty("db.password"));     
				ds = bds;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 기본 생성자
	public JDBCUtil() {
		initJDBCUtil();
	}

	// 매개변수 없는 query를 전달받아 query를 설정하는 생성자
	public JDBCUtil(String sql) {
		this.setSql(sql);
		initJDBCUtil();
	}

	// 매개변수의 배열과 함께 query를 전달받아 각각을 설정하는 생성자
	public JDBCUtil(String sql, Object[] parameters) {
		this.setSql(sql);
		this.setParameters(parameters);
		initJDBCUtil();
	}

	// sql 변수 getter
	public String getSql() {
		return this.sql;
	}

	// sql 변수 setter
	public void setSql(String sql) {
		this.sql = sql;
	}

	// Object[] 변수 setter
	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}

	// sql 및 매개변수 배열 저장
	public void setSqlAndParameters(String sql, Object[] parameters) {  
		this.sql = sql;
		this.parameters = parameters;
	}

	// 매개변수 배열에서 특정위치의 매개변수를 반환하는 메소드
	private Object getParameter(int index) throws Exception {
		if (index >= getParameterSize())
			throw new Exception("INDEX 값이 파라미터의 갯수보다 많습니다.");
		return parameters[index];
	}

	// 매개변수의 개수를 반환하는 메소드
	private int getParameterSize() {
		return parameters == null ? 0 : parameters.length;
	}

	// 현재의 PreparedStatement 를 반환
	private PreparedStatement getPreparedStatement() throws SQLException {
		if (conn == null) {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
		}
		if (pstmt != null) pstmt.close();
		pstmt = conn.prepareStatement(sql);
		// JDBCUtil.printDataSourceStats(ds);
		return pstmt;
	}

	// JDBCUtil 의 쿼리와 매개변수를 이용해 executeQuery 를 수행하는 메소드
	public ResultSet executeQuery() {
		try {
			pstmt = getPreparedStatement();
			for (int i = 0; i < getParameterSize(); i++) {
				pstmt.setObject(i + 1, getParameter(i));
			}
			rs = pstmt.executeQuery();
			return rs;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	// JDBCUtil 의 쿼리와 매개변수를 이용해 executeUpdate 를 수행하는 메소드
	public int executeUpdate() throws SQLException, Exception {
		pstmt = getPreparedStatement();
		int parameterSize = getParameterSize();
		for (int i = 0; i < parameterSize; i++) {
			if (getParameter(i) == null) { // 매개변수 값이 널이 부분이 있을 경우
				pstmt.setString(i + 1, null);
			} else {
				pstmt.setObject(i + 1, getParameter(i));
			}
		}
		return pstmt.executeUpdate();
	}

	// 현재의 CallableStatement 를 반환
	private CallableStatement getCallableStatement() throws SQLException {
		if (conn == null) {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
		}
		if (cstmt != null) cstmt.close();
		cstmt = conn.prepareCall(sql);
		return cstmt;
	}

	// JDBCUtil 의 쿼리와 매개변수를 이용해 CallableStatement 의 execute 를 수행하는 메소드
	public boolean execute(JDBCUtil source) throws SQLException, Exception {
		cstmt = getCallableStatement();
		for (int i = 0; i < source.getParameterSize(); i++) {
			cstmt.setObject(i + 1, source.getParameter(i));
		}
		return cstmt.execute();
	}

	// 자원 반환
	public void close() {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (cstmt != null) {
			try {
				cstmt.close();
				cstmt = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void commit() {
		try {
			conn.commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void rollback() {
		try {
			conn.rollback();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// DBCP Pool 을 종료
	public void shutdownPool() {
		this.close();
		BasicDataSource bds = (BasicDataSource) ds;
		try {
			bds.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// 현재 활성화 상태인 Connection 의 개수와 비활성화 상태인 Connection 개수 출력
	public void printDataSourceStats(DataSource ds) throws SQLException {
		BasicDataSource bds = (BasicDataSource) ds;
		System.out.println("NumActive: " + bds.getNumActive());
		System.out.println("NumIdle: " + bds.getNumIdle());
	}
}
