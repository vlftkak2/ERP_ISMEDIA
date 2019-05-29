package kr.ac.is.ISMEDIA.vo;

public class LongStockVo {

	private String stdate; /* 기준월 */
	private String month; /* 월 */
	private String itemkind; /* 품목계정 */
	private String itemcd; /* 품목코드 */
	private String itemnm; /* 품목명 */
	private String size; /* 규격 */
	private int inqty; /* 입고수량 */
	private int sumout; /* 출고계 */
	private int outqty; /* 출고수량 */
	private int jqty; /* 재고수량 */
	private int coitemcd; /* 품목수 */
	private int seqitemcd; /* 품목순번 */
	private float price; /* 단가 */
	private float amt; /* 금액 */
	private String remark; /* 비고 */
	private String dremark; /* 비고상세 */
	private String overdate; /* 초과일수 */
	
	public String getStdate() {
		return stdate;
	}
	public void setStdate(String stdate) {
		this.stdate = stdate;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getItemkind() {
		return itemkind;
	}
	public void setItemkind(String itemkind) {
		this.itemkind = itemkind;
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
	public int getInqty() {
		return inqty;
	}
	public void setInqty(int inqty) {
		this.inqty = inqty;
	}
	public int getSumout() {
		return sumout;
	}
	public void setSumout(int sumout) {
		this.sumout = sumout;
	}
	public int getOutqty() {
		return outqty;
	}
	public void setOutqty(int outqty) {
		this.outqty = outqty;
	}
	public int getJqty() {
		return jqty;
	}
	public void setJqty(int jqty) {
		this.jqty = jqty;
	}
	public int getCoitemcd() {
		return coitemcd;
	}
	public void setCoitemcd(int coitemcd) {
		this.coitemcd = coitemcd;
	}
	public int getSeqitemcd() {
		return seqitemcd;
	}
	public void setSeqitemcd(int seqitemcd) {
		this.seqitemcd = seqitemcd;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDremark() {
		return dremark;
	}
	public void setDremark(String dremark) {
		this.dremark = dremark;
	}
	public String getOverdate() {
		return overdate;
	}
	public void setOverdate(String overdate) {
		this.overdate = overdate;
	}
	@Override
	public String toString() {
		return "LongStockVo [stdate=" + stdate + ", month=" + month + ", itemkind=" + itemkind + ", itemcd=" + itemcd
				+ ", itemnm=" + itemnm + ", size=" + size + ", inqty=" + inqty + ", sumout=" + sumout + ", outqty="
				+ outqty + ", jqty=" + jqty + ", coitemcd=" + coitemcd + ", seqitemcd=" + seqitemcd + ", price=" + price
				+ ", amt=" + amt + ", remark=" + remark + ", dremark=" + dremark + ", overdate=" + overdate + "]";
	}

	
	
	
}
