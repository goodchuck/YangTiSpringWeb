package springwebprj.main;

public class DnfDTO {

	private String serverId;
	private String characterName;
	private String jobName;
	private String jobGrowName;
	private String characterId;
	
	public DnfDTO(String serverId, String characterName, String jobName, String jobGrowName, String characterId) {
		super();
		this.serverId = serverId;
		this.characterName = characterName;
		this.jobName = jobName;
		this.jobGrowName = jobGrowName;
		this.characterId = characterId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public DnfDTO() {
		
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getJobGrowName() {
		return jobGrowName;
	}

	public void setJobGrowName(String jobGrowName) {
		this.jobGrowName = jobGrowName;
	}

	public String getCharacterId() {
		return characterId;
	}

	public void setCharacterId(String characterId) {
		this.characterId = characterId;
	}



	

	

	
	
}
