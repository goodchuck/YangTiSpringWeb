package springwebprj.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import springwebprj.main.Config;
import springwebprj.main.HealthDAO;
import springwebprj.main.HealthDTO;
import springwebprj.main.Test;

@Controller
@RequestMapping("/db/")
public class DbController {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
	HealthDAO dao = ctx.getBean("hd",HealthDAO.class);
	


	@RequestMapping("userLoginAction")
	public String userLoginAction(HttpServletRequest request, Model model, HttpSession session) {
		if(dao.uselect(request.getParameter("userID")).get(0).getUserPassword().equals(request.getParameter("userPassword"))) {
			session.setAttribute("sessiontest", dao.uselect(request.getParameter("userID")).get(0).getUserID());
			return "redirect:/index";
		}
		
		return "redirect:/userLogin";
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
		if(request.getParameter("userid").equals(request.getParameter("sid"))) {

			dao.delete(Integer.parseInt(request.getParameter("bbsid")));
		}
		else {
		}
		return "redirect:/index";
	}
	
	@RequestMapping("bbsAlterAction")
	public String BbsAlterAction(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws IOException {

		dao.update(request.getParameter("bbsContent"),request.getParameter("bbsTitle"),Integer.parseInt(request.getParameter("bbsid")));
		return "redirect:/index";
	}

	@RequestMapping("/userJoinAction")
	public String dbTest3(HttpServletRequest request, Model model) {

		dao.userjoin(request.getParameter("userID"),request.getParameter("userPassword"),request.getParameter("userName"),request.getParameter("userGender"),request.getParameter("userEmail"));
		return "redirect:/index";
	}
	
	@RequestMapping("/bbsWrite")
	public String dbTest7(HttpServletRequest request,HttpSession session, Model model) {
		String content = "무산소 "+request.getParameter("health1") +" : "+ request.getParameter("h1-1") +" X "+ request.getParameter("h1-2") +" ";
		String content2 = request.getParameter("health2") +" : "+ request.getParameter("h2-1") +" X "+ request.getParameter("h2-2") + " ";
		String content3 = request.getParameter("health3") +" : "+ request.getParameter("h3-1") +" X "+ request.getParameter("h3-2") + " ";
		String content4 = request.getParameter("health4") +" : "+ request.getParameter("h4-1") +" X "+ request.getParameter("h4-2") + " ";
		String content5 = request.getParameter("health5") +" : "+ request.getParameter("h5-1") +" X "+ request.getParameter("h5-2") + " ";
		String content6 = request.getParameter("health6");
		String contentall = content+content2+content3+content4+content5+content6;

		dao.insert((String)session.getAttribute("sessiontest"),request.getParameter("Title"),contentall);
		return "redirect:/index";
	}
}
