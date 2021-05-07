package springwebprj.main;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class HealthDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private HealthDTORowMapper healthDTORowMapper = new HealthDTORowMapper();
	private UserDTORowMapper userDTORowMapper = new UserDTORowMapper();
	
	
	public int update(String bc, String tt, int bi) {
		return jdbcTemplate.update("update bbs set content =?,title=? where bbsid = ?",bc,tt,bi);
	}
	public int delete(int bbsid) {
		return jdbcTemplate.update("update bbs set bbsav = 0 where bbsid = ?",bbsid);
	}
	public int insert(String id, String title, String content) {
		return jdbcTemplate.update("insert into bbs (id, title, content, nowtime) values(?,?,?,now())",id,title,content);
	}
	public int userjoin(String id, String pw, String name, String gender, String email) {
		return jdbcTemplate.update("insert into user values (?,?,?,?,?)",id,pw,name,gender,email);
	}
	public List<HealthDTO> select() {
		List<HealthDTO> hd = jdbcTemplate.query("select * from bbs order by bbsid desc",
				healthDTORowMapper
				);
		return hd;
	}
	
	public List<UserDTO> uselect(String userID) {
		List<UserDTO> ud = jdbcTemplate.query("select * from user where userID = ?",
				new Object[] {userID},
				userDTORowMapper);
		return ud;
	}
//	public List<HealthDTO> select(int start, int size) {
//		List<HealthDTO> hd = jdbcTemplate.query(
//				"select * from bbs order by bbsid desc limit ?,?",
//				new Object[] {start, size},
//				healthDTORowMapper
//				);
//		return hd;
//	}
	
	
//	public ArrayList<HealthDTO> select() {
//		String SQL = "SELECT * FROM BBS ORDER BY bbsid desc";
//		ArrayList<HealthDTO> hd = new ArrayList<HealthDTO>();
//		try {
//			conn = dataSource.getConnection();
//			pstmt = conn.prepareStatement(SQL);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				hd.add(new HealthDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)));
//			}
//			return hd;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
//			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
//			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
//		}
//		return hd;
//	}
}
