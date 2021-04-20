package springwebprj.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

		test20.setTest1("33");
		test20.setTest2("44");
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

	@RequestMapping("/dbTest.do")
	public String dbTest(Model model) {
		Connection conn = null;
		Statement st = null;

		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select now() as now;");

			while (rs.next()) {
				model.addAttribute("serverTime", rs.getString("now"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "test";
	}

	@RequestMapping("/dbTest.do2")
	public String dbTest2(Model model) {
		Connection conn = null;
		Statement st = null;

		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from evaluation;");

			while (rs.next()) {
				model.addAttribute("evaluationID", rs.getString("evaluationID"));
				model.addAttribute("userID", rs.getString("userID"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "test";
	}
}
