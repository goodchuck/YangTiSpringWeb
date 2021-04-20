package springwebprj.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;


public class Api {

	public String[] searchId(String reserverId, String recharacterName){
		try {
			String serverId = reserverId;
			String characterName = recharacterName;
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
			System.out.println("ê²°ê³¼ë¬? : " + response.toString());
			JSONObject myResponse = new JSONObject(response.toString());
			JSONArray jArray = myResponse.getJSONArray("rows");
			
			String parseserverId = jArray.getJSONObject(0).getString("serverId");
			String parsecharacterName = jArray.getJSONObject(0).getString("characterName");
			String parsejobName = jArray.getJSONObject(0).getString("jobName");
			String parsejobGrowName = jArray.getJSONObject(0).getString("jobGrowName");
			String parsecharacterId = jArray.getJSONObject(0).getString("characterId");
			//System.out.println("serverId : " + serverId);
			//System.out.println("characterName : " + charactername);
			return new String[] {parseserverId, parsecharacterName, parsejobName, parsejobGrowName, parsecharacterId};
		} catch(Exception e) {
			System.out.println("?˜¤ë¥? : " + e);
		}
		return new String[] {"-1", "-2","-3","-4","-5"};
	}
	
	public String[] searchItem(String reserverId, String recharacterId) {
		try {
			String serverId = reserverId;
			String characterId = recharacterId;
			String htmlUrl = "https://api.neople.co.kr/df/servers/"+serverId+"/characters/"+characterId+"/equip/equipment?apikey=oMDk2YvEtfIzJG8SfXLWDZ3km3J1pKu6";
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
			System.out.println("ê²°ê³¼ë¬? : " + response.toString());
			JSONObject myResponse = new JSONObject(response.toString());
			JSONArray jArray = myResponse.getJSONArray("equipment");
			
			String parseitemName = jArray.getJSONObject(0).getString("itemName");
			
			
			return new String[] {parseitemName};
		} catch (Exception e) {
			
		}
		return new String[] {"?˜¤ë¥?"};
	}
	
	public String[] searchTimeline(String reserverId, String recharacterId) {
		try {
			String serverId = reserverId;
			String characterId = recharacterId;
			String htmlUrl = "https://api.neople.co.kr/df/servers/"+serverId+"/characters/"+characterId+"/timeline?limit=100&code=505&apikey=oMDk2YvEtfIzJG8SfXLWDZ3km3J1pKu6";
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
			System.out.println("ê²°ê³¼ë¬? : " + response.toString());
			JSONObject myResponse = new JSONObject(response.toString());
			System.out.println("?…Œ?Š¤?Š¸1 : " + myResponse);
			JSONArray jArray = myResponse.getJSONArray("rows");
			String parseitemName2 = jArray.getJSONObject(0).getString("name");
			System.out.println("?…Œ?Š¤?Š¸2 : " + parseitemName2);
			//String[] testarray = new String[100];
			//testarray[0] = parseitemName;
			/*for(int i=0; i<jArray.length(); i++) {
				
				String parseitemName = jArray.getJSONObject(i).getString("itemName");
				testarray[i] = parseitemName;
			} */
			return new String[] {parseitemName2};
		} catch (Exception e) {
			
		}
		return new String[] {"?˜¤ë¥?"};
	}
}
