package kr.ac.is.ISMEDIA.vo;

public class UserVo {
	
	private String id;
	private String password;
	private String name;
	private String teamname;
	private String authmenu;
	private String auth;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public String getAuthmenu() {
		return authmenu;
	}
	public void setAuthmenu(String authmenu) {
		this.authmenu = authmenu;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", password=" + password + ", name=" + name + ", teamname=" + teamname
				+ ", authmenu=" + authmenu + ", auth=" + auth + "]";
	}
	

	
	

}
