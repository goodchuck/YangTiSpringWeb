package springwebprj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import java.sql.PreparedStatement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import springwebprj.main.Config;
import springwebprj.main.HealthDAO;
import springwebprj.main.HealthDTO;
import springwebprj.main.MemberRegistRequest;
import springwebprj.main.Test;


@Controller
@RequestMapping("/")
public class HomeController {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	
//	GenericXmlApplicationContext ctx2 = new GenericXmlApplicationContext("classpath:dispatcher-servlet.xml");
	
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
	HealthDAO dao = ctx.getBean("hd",HealthDAO.class);

	//Test test = ctx.getBean("test",Test.class);
	//HealthDAO healthdao = ctx.getBean("hd", HealthDAO.class);

//	public HomeController(DataSource dataSource) {
//		jdbcTemplate = new JdbcTemplate(dataSource);
//	}
//	@Autowired
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
	
	
//	private HealthDTORowMapper healthDTORowMapper = new HealthDTORowMapper();
	
	
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
	

//	public List<HealthDTO> select() {
//		List<HealthDTO> hd = jdbcTemplate.query("select * from bbs order by bbsid desc",
//				healthDTORowMapper
//				);
//	return hd;
//	}
	
	@RequestMapping("index")
	public String index(HttpServletRequest request, Model model) {
		

		model.addAttribute("testarray",dao.select());
//		ArrayList<HealthDTO> hd = new ArrayList<HealthDTO>();
//
//		String SQL = "SELECT * FROM BBS ORDER BY bbsid desc";
//
//		try {
//			conn = dataSource.getConnection();
//			pstmt = conn.prepareStatement(SQL);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				hd.add(new HealthDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)));
//				model.addAttribute("testarray", hd);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
//			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
//			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
//		}
		
		
		
		return "index";
	}

	@RequestMapping("Ytbbs")
	public void Ytbbs() {

	}

	@RequestMapping("versionnote")
	public void versionnote() {

	}

	@RequestMapping("gallery")
	public void gallery() {

	}

	@RequestMapping("dnftest")
	public void dnftest() {

	}
	
	@RequestMapping("userJoin")
	public void userJoin() {

	}
	
	@RequestMapping("userLogin")
	public void userLogin() {

	}
	
	@RequestMapping("userLogout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	

	
}
