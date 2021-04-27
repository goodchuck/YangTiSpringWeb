package springwebprj.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import springwebprj.main.Config;
import springwebprj.main.HealthDTO;

@Component
public class HealthDAO {
	
	@Autowired
	BasicDataSource dataSource;
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
	
	public ArrayList<HealthDTO> select() {
		String SQL = "SELECT * FROM BBSTEST ORDER BY bbsid desc";
		ArrayList<HealthDTO> hd = new ArrayList<HealthDTO>();
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hd.add(new HealthDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
			return hd;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}
		return hd;
	}
}
