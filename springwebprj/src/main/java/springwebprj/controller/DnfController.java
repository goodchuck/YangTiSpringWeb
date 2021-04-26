package springwebprj.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
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
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import springwebprj.main.Config;
import springwebprj.main.DnfDTO;
import springwebprj.main.HealthDTO;
import springwebprj.main.MemberRegistRequest;
import springwebprj.main.Test;
import springwebprj.test.Api;



@Controller
@RequestMapping("/dnf/")
public class DnfController {

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
	
	Api api = new Api();
	
	@RequestMapping("dnftest")
	public String dnftest(HttpServletRequest request, Model model) {
		try {
			//String serverId = reserverId;
			//String characterName = recharacterName;
			String serverId = "prey";
			String characterName = "%ec%9e%98%ed%95%a0%ea%b2%8c%ec%97%ac";
			String htmlUrl = "https://api.neople.co.kr/df/servers/"+serverId +"/characters?characterName="+characterName+"&apikey=oMDk2YvEtfIzJG8SfXLWDZ3km3J1pKu6";
			HttpURLConnection conn = (HttpURLConnection) new URL(htmlUrl).openConnection();
			conn.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine= in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			//String[] test = new String[2];
			System.out.println("테스트? : " + response.toString());
			JSONObject myResponse = new JSONObject(response.toString());
			JSONArray jArray = myResponse.getJSONArray("rows");
			
			String parseserverId = jArray.getJSONObject(0).getString("serverId");
			String parsecharacterName = jArray.getJSONObject(0).getString("characterName");
			String parsejobName = jArray.getJSONObject(0).getString("jobName");
			String parsejobGrowName = jArray.getJSONObject(0).getString("jobGrowName");
			String parsecharacterId = jArray.getJSONObject(0).getString("characterId");
			//System.out.println("serverId : " + serverId);
			//System.out.println("characterName : " + charactername);
			ArrayList<DnfDTO> dd = new ArrayList<DnfDTO>();
			dd.add(new DnfDTO(parseserverId, parsecharacterName, parsejobName, parsejobGrowName, parsecharacterId));
			model.addAttribute("dd", dd);
			String[] ts500 = new String[] {parseserverId, parsecharacterName, parsejobName, parsejobGrowName, parsecharacterId};
			//System.out.println("테스트2 :" + ts500[0]);
			model.addAttribute("ts500", ts500);
			return "dnftest";
		} catch(Exception e) {
			System.out.println("?삤瑜? : " + e);
		}

		return "dnftest";
	}
	
	@RequestMapping("dnftest2")
	public String dnftest2(HttpServletRequest request, Model model) {
		try {
			//String serverId = reserverId;
			//String characterName = recharacterName;
			String serverId = "prey";
			String characterName = "%ec%9e%98%ed%95%a0%ea%b2%8c%ec%97%ac";
			String htmlUrl = "https://api.neople.co.kr/df/servers/"+serverId +"/characters?characterName="+characterName+"&apikey=oMDk2YvEtfIzJG8SfXLWDZ3km3J1pKu6";
			HttpURLConnection conn = (HttpURLConnection) new URL(htmlUrl).openConnection();
			conn.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine= in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			//String[] test = new String[2];
			System.out.println("테스트? : " + response.toString());
			JSONObject myResponse = new JSONObject(response.toString());
			JSONArray jArray = myResponse.getJSONArray("rows");
			
			String parseserverId = jArray.getJSONObject(0).getString("serverId");
			String parsecharacterName = jArray.getJSONObject(0).getString("characterName");
			String parsejobName = jArray.getJSONObject(0).getString("jobName");
			String parsejobGrowName = jArray.getJSONObject(0).getString("jobGrowName");
			String parsecharacterId = jArray.getJSONObject(0).getString("characterId");
			//System.out.println("serverId : " + serverId);
			//System.out.println("characterName : " + charactername);
			ArrayList<DnfDTO> dd = new ArrayList<DnfDTO>();
			dd.add(new DnfDTO(parseserverId, parsecharacterName, parsejobName, parsejobGrowName, parsecharacterId));
			model.addAttribute("dd", dd);
			String[] ts500 = new String[] {parseserverId, parsecharacterName, parsejobName, parsejobGrowName, parsecharacterId};
			//System.out.println("테스트2 :" + ts500[0]);
			model.addAttribute("ts500", ts500);
			return "dnftest";
		} catch(Exception e) {
			System.out.println("?삤瑜? : " + e);
		}

		return "dnftest";
	}


	
}
