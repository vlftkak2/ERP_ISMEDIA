package kr.ac.is.ISMEDIA.vo;

public class ProjectVo {
	
	private String orderdt;
	private String pjtno;
	private String pjtnm;
	private String itemcd;
	private String itemnm;
	private String size;
	private int qty;
	private String customnm;
	public String getOrderdt() {
		return orderdt;
	}
	public void setOrderdt(String orderdt) {
		this.orderdt = orderdt;
	}
	public String getPjtno() {
		return pjtno;
	}
	public void setPjtno(String pjtno) {
		this.pjtno = pjtno;
	}
	public String getPjtnm() {
		return pjtnm;
	}
	public void setPjtnm(String pjtnm) {
		this.pjtnm = pjtnm;
	}
	public String getItemcd() {
		return itemcd;
	}
	public void setItemcd(String itemcd) {
		this.itemcd = itemcd;
	}
	public String getItemnm() {
		return itemnm;
	}
	public void setItemnm(String itemnm) {
		this.itemnm = itemnm;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getCustomnm() {
		return customnm;
	}
	public void setCustomnm(String customnm) {
		this.customnm = customnm;
	}
	@Override
	public String toString() {
		return "ProjectVo [orderdt=" + orderdt + ", pjtno=" + pjtno + ", pjtnm=" + pjtnm + ", itemcd=" + itemcd
				+ ", itemnm=" + itemnm + ", size=" + size + ", qty=" + qty + ", customnm=" + customnm + "]";
	}
	
	
	

}
