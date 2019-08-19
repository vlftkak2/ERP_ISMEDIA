package kr.ac.is.ISMEDIA.vo;

public class FileVersionVo {
	
	private Long no;
	private String menu;
	private String path;
	private String filename;
	private String division;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	@Override
	public String toString() {
		return "FileVersion [no=" + no + ", menu=" + menu + ", path=" + path + ", filename=" + filename + ", division="
				+ division + "]";
	}
	
}
