package kr.ac.is.ISMEDIA.vo;

public class UserVo {
	
	private String ID;
	private String Password;
	private String Name;
	private String TeamName;
	private String position;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "UserVo [ID=" + ID + ", Password=" + Password + ", Name=" + Name + ", TeamName=" + TeamName
				+ ", position=" + position + "]";
	}
	
	

}
