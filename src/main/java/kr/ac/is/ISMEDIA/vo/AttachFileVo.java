package kr.ac.is.ISMEDIA.vo;

public class AttachFileVo {
	
	private Long fNO;
	private Long no;
	private String path;
	private String orgname;
	private String savename;
	private String url;
	private long filesize;
	private int groupno;
	private int orderno;
	public Long getfNO() {
		return fNO;
	}
	public void setfNO(Long fNO) {
		this.fNO = fNO;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public int getGroupno() {
		return groupno;
	}
	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	@Override
	public String toString() {
		return "AttachFileVo [fNO=" + fNO + ", no=" + no + ", path=" + path + ", orgname=" + orgname + ", savename="
				+ savename + ", url=" + url + ", filesize=" + filesize + ", groupno=" + groupno + ", orderno=" + orderno
				+ "]";
	}
	
	
	

}
