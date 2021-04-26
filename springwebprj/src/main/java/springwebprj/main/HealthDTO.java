package springwebprj.main;

public class HealthDTO {

	private int bbsid;
	private String id;
	private String title;
	private String content;
	private int bbsav;
	public int getBbsid() {
		return bbsid;
	}
	public void setBbsid(int bbsid) {
		this.bbsid = bbsid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getBbsav() {
		return bbsav;
	}
	public void setBbsav(int bbsav) {
		this.bbsav = bbsav;
	}
	public HealthDTO() {
		
	}
	
	public HealthDTO(int bbsid, String id, String title, String content, int bbsav) {
		super();
		this.bbsid = bbsid;
		this.id = id;
		this.title = title;
		this.content = content;
		this.bbsav = bbsav;
	}
	

	

	
	
}
