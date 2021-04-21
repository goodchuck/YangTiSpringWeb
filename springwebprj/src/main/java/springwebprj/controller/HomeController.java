package springwebprj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import springwebprj.main.Config;
import springwebprj.main.Test;


@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	BasicDataSource dataSource;

	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

	Test test20 = ctx.getBean("test", Test.class);

	@RequestMapping("index")
	public String index(Model model) {

		test20.setTest1("테스트를 위한");
		test20.setTest2("글 테스트");
		model.addAttribute("test20", test20);
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
	
	@RequestMapping("userLoginAction")
	public String userLoginAction(HttpServletRequest request, Model model) {
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, request.getParameter("userID"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(request.getParameter("userPassword"))) {
					model.addAttribute("ts1", rs.getString("userPassword"));
					return "test";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}
		return "test";
	}
	
	@RequestMapping("userJoinAction")
	public void userJoinAction(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		   String userID = null;
		   String userPassword = null;
		   String userEmail = null;
		   if(request.getParameter("userID") != null) {
			   userID = request.getParameter("userID");
		   }
		   if(request.getParameter("userPassword") != null) {
			   userPassword = request.getParameter("userPassword");
		   }
		   if(request.getParameter("userEmail") != null) {
			   userEmail = request.getParameter("userEmail");
		   }

	}

	
	@RequestMapping("/dbTest.do3")
	public String dbTest3(HttpServletRequest httpServletRequest, Model model) {
		String SQL = "INSERT INTO USER VALUES (?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, httpServletRequest.getParameter("userID"));
			pstmt.setString(2, httpServletRequest.getParameter("userPassword"));
			pstmt.setString(3, httpServletRequest.getParameter("userName"));
			pstmt.setString(4, httpServletRequest.getParameter("userGender"));
			pstmt.setString(5, httpServletRequest.getParameter("userEmail"));
			pstmt.executeUpdate();
			//st = conn.createStatement();
			//ResultSet rs = st.executeQuery("select * from bbs;");
			/*
			 * while (rs.next()) { model.addAttribute("evaluationID",
			 * rs.getString("bbsID")); model.addAttribute("userID", rs.getString("userID"));
			 * }
			 */
			model.addAttribute("ts", "확인");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}
		return "userJoinAction";
	}
	
	@RequestMapping("/dbTest.do4")
	public String dbTest4(Model model) {
		String SQL = "SELECT * FROM USER WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "1234");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals("1234")) {
					model.addAttribute("userID", rs.getString("userID"));
					model.addAttribute("userPassword", rs.getString("userPassword"));
				}
			}
			model.addAttribute("ts", "확인");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}
		return "test";
	}
	
	@RequestMapping("/dbTest.do5")
	public String dbTest5(HttpServletRequest httpServletRequest, Model model) {
		String SQL = "INSERT INTO BBSTEST VALUES (?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "12345");
			pstmt.setString(2, httpServletRequest.getParameter("Title"));
			pstmt.setString(3, httpServletRequest.getParameter("Content"));
			pstmt.executeUpdate();

			model.addAttribute("ts1", httpServletRequest.getParameter("Title"));
			model.addAttribute("ts2", httpServletRequest.getParameter("Content"));
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}
		return "index";
	}
}
