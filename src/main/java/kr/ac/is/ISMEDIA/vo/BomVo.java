package kr.ac.is.ISMEDIA.vo;

public class BomVo {
	
	private int seqno;
	private String pjtno;
	private String pjtnm;
	private String pitemcd;
	private String pitemnm;
	private String itemcd;
	private String itemnm;
	private String size;
	private String material;
	private String maker;
	private String reference;
	private String level;
	private int bomst;
	private int bomsu;
	private String currency;
	private float price;
	private float amt;
	private String customnm;
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
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
	public String getPitemcd() {
		return pitemcd;
	}
	public void setPitemcd(String pitemcd) {
		this.pitemcd = pitemcd;
	}
	public String getPitemnm() {
		return pitemnm;
	}
	public void setPitemnm(String pitemnm) {
		this.pitemnm = pitemnm;
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
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getBomst() {
		return bomst;
	}
	public void setBomst(int bomst) {
		this.bomst = bomst;
	}
	public int getBomsu() {
		return bomsu;
	}
	public void setBomsu(int bomsu) {
		this.bomsu = bomsu;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getAmt() {
		return amt;
	}
	public void setAmt(float amt) {
		this.amt = amt;
	}
	public String getCustomnm() {
		return customnm;
	}
	public void setCustomnm(String customnm) {
		this.customnm = customnm;
	}
	@Override
	public String toString() {
		return "BomVo [seqno=" + seqno + ", pjtno=" + pjtno + ", pjtnm=" + pjtnm + ", pitemcd=" + pitemcd + ", pitemnm="
				+ pitemnm + ", itemcd=" + itemcd + ", itemnm=" + itemnm + ", size=" + size + ", material=" + material
				+ ", maker=" + maker + ", reference=" + reference + ", level=" + level + ", bomst=" + bomst + ", bomsu="
				+ bomsu + ", currency=" + currency + ", price=" + price + ", amt=" + amt + ", customnm=" + customnm
				+ "]";
	}
	
	

}
