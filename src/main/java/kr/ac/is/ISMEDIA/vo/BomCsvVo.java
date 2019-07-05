package kr.ac.is.ISMEDIA.vo;

public class BomCsvVo {
	
	private int 순서;
	private String 모품목코드;
	private String 모품목명;
	private String 자품목코드;
	private String 품목명;
	private String 규격;
	private String 패키지;
	private String 메이커;
	private String reference;
	private String 레벨;
	private int 표준원수;
	private int 소요원수;
	private String 화폐;
	private String 단가;
	private String 금액;
	private String 거래처;
	public int get순서() {
		return 순서;
	}
	public void set순서(int 순서) {
		this.순서 = 순서;
	}
	public String get모품목코드() {
		return 모품목코드;
	}
	public void set모품목코드(String 모품목코드) {
		this.모품목코드 = 모품목코드;
	}
	public String get모품목명() {
		return 모품목명;
	}
	public void set모품목명(String 모품목명) {
		this.모품목명 = 모품목명;
	}
	public String get자품목코드() {
		return 자품목코드;
	}
	public void set자품목코드(String 자품목코드) {
		this.자품목코드 = 자품목코드;
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
	public String get패키지() {
		return 패키지;
	}
	public void set패키지(String 패키지) {
		this.패키지 = 패키지;
	}
	public String get메이커() {
		return 메이커;
	}
	public void set메이커(String 메이커) {
		this.메이커 = 메이커;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String get레벨() {
		return 레벨;
	}
	public void set레벨(String 레벨) {
		this.레벨 = 레벨;
	}
	public int get표준원수() {
		return 표준원수;
	}
	public void set표준원수(int 표준원수) {
		this.표준원수 = 표준원수;
	}
	public int get소요원수() {
		return 소요원수;
	}
	public void set소요원수(int 소요원수) {
		this.소요원수 = 소요원수;
	}
	public String get화폐() {
		return 화폐;
	}
	public void set화폐(String 화폐) {
		this.화폐 = 화폐;
	}
	public String get단가() {
		return 단가;
	}
	public void set단가(String 단가) {
		this.단가 = 단가;
	}
	public String get금액() {
		return 금액;
	}
	public void set금액(String 금액) {
		this.금액 = 금액;
	}
	public String get거래처() {
		return 거래처;
	}
	public void set거래처(String 거래처) {
		this.거래처 = 거래처;
	}
	@Override
	public String toString() {
		return "BomCsvVo [순서=" + 순서 + ", 모품목코드=" + 모품목코드 + ", 모품목명=" + 모품목명 + ", 자품목코드=" + 자품목코드 + ", 품목명=" + 품목명
				+ ", 규격=" + 규격 + ", 패키지=" + 패키지 + ", 메이커=" + 메이커 + ", reference=" + reference + ", 레벨=" + 레벨 + ", 표준원수="
				+ 표준원수 + ", 소요원수=" + 소요원수 + ", 화폐=" + 화폐 + ", 단가=" + 단가 + ", 금액=" + 금액 + ", 거래처=" + 거래처 + "]";
	}

}
