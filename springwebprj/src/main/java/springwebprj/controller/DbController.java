package springwebprj.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import springwebprj.main.Test;

@Controller
@RequestMapping("/db/")
public class DbController {

	@Autowired
	BasicDataSource dataSource;
	
//	@Autowired
//	Test test;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@RequestMapping("userLoginAction")
	public String userLoginAction(HttpServletRequest request, Model model, HttpSession session) {
		String SQL = "SELECT * FROM USER WHERE userID = ?";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, request.getParameter("userID"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("userPassword").equals(request.getParameter("userPassword"))) {
					model.addAttribute("ts1", rs.getString("userPassword"));
					model.addAttribute("testForm",rs.getString("userID"));
					session.setAttribute("sessiontest", rs.getString("userID"));
					//model.addAttribute("msg", "success");
					return "redirect:/index";
				} else {
					//bindingResult.rejectValue("pw","notMatch", "���̵�� ��й�ȣ�� �����ʽ��ϴ�.");
					model.addAttribute("msg", "failure");
					return "userLogin";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "failure");
			return "userLogin";
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}
		return "redirect:/userLogin";
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

	
	@RequestMapping("bbsview")
	public String bbsview(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
	{
		model.addAttribute("bbstitle",request.getParameter("bbstitle"));
		model.addAttribute("bbscontent",request.getParameter("bbscontent"));
		model.addAttribute("bbsid",request.getParameter("bbsid"));
		return "bbsview";
	}
	
	@RequestMapping("bbswrite")
	public String bbswrite(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
	{
		model.addAttribute("userid",request.getParameter("userId"));
		return "bbswrite";
	}
	
	@RequestMapping("bbsDeleteAction")
	public String BbsDeleteAction(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws IOException {
		System.out.println(request.getParameter("sid"));
		if(request.getParameter("userid").equals(request.getParameter("sid"))) {
		String SQL = "UPDATE BBSTEST SET BBSAV = 0 WHERE BBSID = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, Integer.parseInt(request.getParameter("bbsid")));
			pstmt.executeUpdate();
			model.addAttribute("msg", request.getParameter("bbsid"));
			return "redirect:/index";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "failure");
			//System.out.println("�����̾ƴ�1");
			return "redirect:/index";
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}

		}
		else {
			//System.out.println("�����̾ƴ�2");
		}
		return "redirect:/index";
	}
	
	@RequestMapping("bbsAlterAction")
	public String BbsAlterAction(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws IOException {
		String SQL = "UPDATE BBSTEST SET content = ?, title = ? WHERE BBSID = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, request.getParameter("bbsContent"));
			pstmt.setString(2, request.getParameter("bbsTitle"));
			pstmt.setInt(3, Integer.parseInt(request.getParameter("bbsid")));
			pstmt.executeUpdate();
			model.addAttribute("msg", request.getParameter("bbsid"));
			return "redirect:/index";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "failure");
			//System.out.println("�����̾ƴ�1");
			return "redirect:/index";
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}
	}
	
	@RequestMapping("/dbTest.do3")
	public String dbTest3(HttpServletRequest httpServletRequest, Model model) {
		String SQL = "INSERT INTO USER VALUES (?,?,?,?,?)";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, httpServletRequest.getParameter("userID"));
			pstmt.setString(2, httpServletRequest.getParameter("userPassword"));
			pstmt.setString(3, httpServletRequest.getParameter("userName"));
			pstmt.setString(4, httpServletRequest.getParameter("userGender"));
			pstmt.setString(5, httpServletRequest.getParameter("userEmail"));
			pstmt.executeUpdate();

			//model.addAttribute("ts", "Ȯ��");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/dbTest.do4")
	public String dbTest4(Model model) {
		String SQL = "SELECT * FROM USER WHERE userID = ?";

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
			//model.addAttribute("ts", "Ȯ��");
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
	public String dbTest5(HttpServletRequest httpServletRequest,HttpSession session, Model model) {
		String SQL = "INSERT INTO BBSTEST (id, title, content) VALUES (?,?,?)";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, (String)session.getAttribute("sessiontest"));
			pstmt.setString(2, httpServletRequest.getParameter("Title"));
			pstmt.setString(3, httpServletRequest.getParameter("Content"));
			pstmt.executeUpdate();

			model.addAttribute("ts1", httpServletRequest.getParameter("Title"));
			model.addAttribute("ts2", httpServletRequest.getParameter("Content"));
			model.addAttribute("ts3", httpServletRequest.getParameter("favoriteOsNames"));
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/dbTest.do6")
	public String dbTest6(HttpServletRequest httpServletRequest,HttpSession session, Model model) {
		String SQL = "INSERT INTO BBSTEST (id, title, content) VALUES (?,?,?)";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, (String)session.getAttribute("sessiontest"));
			pstmt.setString(2, httpServletRequest.getParameter("Title"));
			pstmt.setString(3, httpServletRequest.getParameter("Content"));
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/dbTest.do7")
	public String dbTest7(HttpServletRequest request,HttpSession session, Model model) {
		String SQL = "INSERT INTO BBSTEST (id, title, content) VALUES (?,?,?)";
		String content = "무산소 "+request.getParameter("health1") +" : "+ request.getParameter("h1-1") +" X "+ request.getParameter("h1-2") +" ";
		String content2 = request.getParameter("health2") +" : "+ request.getParameter("h2-1") +" X "+ request.getParameter("h2-2") + " ";
		String content3 = request.getParameter("health3") +" : "+ request.getParameter("h3-1") +" X "+ request.getParameter("h3-2") + " ";
		String content4 = request.getParameter("health4") +" : "+ request.getParameter("h4-1") +" X "+ request.getParameter("h4-2") + " ";
		String content5 = request.getParameter("health5") +" : "+ request.getParameter("h5-1") +" X "+ request.getParameter("h5-2") + " ";
		String content6 = request.getParameter("health6");
		String contentall = content+content2+content3+content4+content5+content6;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, (String)session.getAttribute("sessiontest"));
			pstmt.setString(2, request.getParameter("Title"));
			pstmt.setString(3, contentall);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}
		return "redirect:/index";
	}
}
