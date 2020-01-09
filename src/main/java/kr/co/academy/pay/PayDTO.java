package kr.co.academy.pay;

public class PayDTO {
	
	private int p_no;        //결제내역 일련번호
	private String c_code;   //강좌 분류(토익/토플등)
	private String w_code;   //강의코드
	private String tc_name;  //강사이름
	private int c_price;     //강의 가격
	private String c_start;  //강의 시작일
	private String p_sts;    //현재 상태(수료,환불,제적,진행)
	private String m_id;     //영수증 (아이디)
	private String m_name;   //영수증 (이름)
	private String ap_no;    //영수증 (주문번호)
	private String ap_pay;   //영수증 (결제방법) 
	private String ap_date;  //영수증 (결제일)
	private String c_prod;   //강좌 제목
	
	
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getC_code() {
		return c_code;
	}
	public void setC_code(String c_code) {
		this.c_code = c_code;
	}
	public String getW_code() {
		return w_code;
	}
	public void setW_code(String w_code) {
		this.w_code = w_code;
	}
	public String getTc_name() {
		return tc_name;
	}
	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}
	public int getC_price() {
		return c_price;
	}
	public void setC_price(int c_price) {
		this.c_price = c_price;
	}
	public String getC_start() {
		return c_start;
	}
	public void setC_start(String c_start) {
		this.c_start = c_start;
	}
	public String getP_sts() {
		return p_sts;
	}
	public void setP_sts(String p_sts) {
		this.p_sts = p_sts;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getAp_no() {
		return ap_no;
	}
	public void setAp_no(String ap_no) {
		this.ap_no = ap_no;
	}
	public String getAp_pay() {
		return ap_pay;
	}
	public void setAp_pay(String ap_pay) {
		this.ap_pay = ap_pay;
	}
	public String getAp_date() {
		return ap_date;
	}
	public void setAp_date(String ap_date) {
		this.ap_date = ap_date;
	}
	public String getC_prod() {
		return c_prod;
	}
	public void setC_prod(String c_prod) {
		this.c_prod = c_prod;
	}
	
	
	

	
	
	
	
	
	
	
	

}//class end
