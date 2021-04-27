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

import java.sql.PreparedStatement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import springwebprj.main.Config;
import springwebprj.main.HealthDTO;
import springwebprj.main.MemberRegistRequest;
import springwebprj.main.Test;


@Controller
@RequestMapping("/")
public class HomeController {


	@Autowired 
	BasicDataSource dataSource;


	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

	
//	@ModelAttribute("loginTypes")
//	protected List<String> referenceData() throws Exception {
//		List<String> loginTypes = new ArrayList<String>();
//		loginTypes.add("일반회원");
//		loginTypes.add("기업회원");
//		loginTypes.add("헤드헌터회원");
//		return loginTypes;
//	}
	
	Test test20 = ctx.getBean(Test.class);
	MemberRegistRequest mrr = ctx.getBean(MemberRegistRequest.class);
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	@RequestMapping("index")
	public String index(HttpServletRequest request, Model model) {
		
		test20.setTest1("테스트를 위한");
		test20.setTest2("글 테스트");
		model.addAttribute("test20", test20);
		List<String> nameList = new ArrayList<String>(Arrays.asList("홍길동", "김철수", "박영희"));
		ArrayList<HealthDTO> hd = new ArrayList<HealthDTO>();
		//HealthDTO dto = new HealthDTO();
		model.addAttribute("nameList", nameList);
		//HealthDAO healthdao = new HealthDAO();
		mrr.setFavoriteOs(new String[] {"유산소","무산소"});
		model.addAttribute("favoriteOsNames", mrr.getFavoriteOs());
		String SQL = "SELECT * FROM BBSTEST ORDER BY bbsid desc";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hd.add(new HealthDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
				model.addAttribute("testarray", hd);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) { e.printStackTrace();}
		}
		
		//model.addAttribute("testarray",healthdao.select());

		
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
