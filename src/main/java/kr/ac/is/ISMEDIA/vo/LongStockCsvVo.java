package kr.ac.is.ISMEDIA.vo;

public class LongStockCsvVo {
	
	  private String 기준월;
	  private String 월;
	  private String 품목코드;
	  private String 품목명;
	  private String 규격;
	  private int 입고수량;
	  private int 출고계;
	  private int 출고;
	  private int 재고;
	  private int 품목수;
	  private int 품목순번;
	  private float 단가;
	  private float 금액;
	  private String 비고;
	  private String 비고상세;
	  private String 초과일수;
	  
	public String get기준월() {
		return 기준월;
	}
	public void set기준월(String 기준월) {
		this.기준월 = 기준월;
	}
	public String get월() {
		return 월;
	}
	public void set월(String 월) {
		this.월 = 월;
	}
	public String get품목코드() {
		return 품목코드;
	}
	public void set품목코드(String 품목코드) {
		this.품목코드 = 품목코드;
	}
	public String get품목명() {
		return 품목명;
	}
	public void set품목명(String 품목명) {
		this.품목명 = 품목명;
	}
	public String get규격() {
		return 규격;
	}
	public void set규격(String 규격) {
		this.규격 = 규격;
	}
	public int get입고수량() {
		return 입고수량;
	}
	public void set입고수량(int 입고수량) {
		this.입고수량 = 입고수량;
	}
	public int get출고계() {
		return 출고계;
	}
	public void set출고계(int 출고계) {
		this.출고계 = 출고계;
	}
	public int get출고() {
		return 출고;
	}
	public void set출고(int 출고) {
		this.출고 = 출고;
	}
	public int get재고() {
		return 재고;
	}
	public void set재고(int 재고) {
		this.재고 = 재고;
	}
	public int get품목수() {
		return 품목수;
	}
	public void set품목수(int 품목수) {
		this.품목수 = 품목수;
	}
	public int get품목순번() {
		return 품목순번;
	}
	public void set품목순번(int 품목순번) {
		this.품목순번 = 품목순번;
	}
	public float get단가() {
		return 단가;
	}
	public void set단가(float 단가) {
		this.단가 = 단가;
	}
	public float get금액() {
		return 금액;
	}
	public void set금액(float 금액) {
		this.금액 = 금액;
	}
	public String get비고() {
		return 비고;
	}
	public void set비고(String 비고) {
		this.비고 = 비고;
	}
	public String get비고상세() {
		return 비고상세;
	}
	public void set비고상세(String 비고상세) {
		this.비고상세 = 비고상세;
	}
	public String get초과일수() {
		return 초과일수;
	}
	public void set초과일수(String 초과일수) {
		this.초과일수 = 초과일수;
	}
	
	@Override
	public String toString() {
		return "LongStockCsvVo [기준월=" + 기준월 + ", 월=" + 월 + ", 품목코드=" + 품목코드 + ", 품목명=" + 품목명 + ", 규격=" + 규격 + ", 입고수량="
				+ 입고수량 + ", 출고계=" + 출고계 + ", 출고=" + 출고 + ", 재고=" + 재고 + ", 품목수=" + 품목수 + ", 품목순번=" + 품목순번 + ", 단가=" + 단가
				+ ", 금액=" + 금액 + ", 비고=" + 비고 + ", 비고상세=" + 비고상세 + ", 초과일수=" + 초과일수 + "]";
	}
	  
	  

}
