package kr.co.academy.apply;

public class ApplyDTO {
	private String ap_no;	//주문번호
    private int w_code;		//강좌코드
    private String tc_name; //강사명
    private String ap_pay; // 결제방법
    private String ap_date;	//결제일
    private String p_sts;
    private String c_prod;	//강좌명
    private String c_start; //강좌시작일
    private int c_price;
    
    //수강목록 칼럼 추가
    private int p_no;
    private String m_id;
    private String m_name;
    private String m_job;
    private String m_email;
    private String m_level;
    private String m_phone;
    
    private int c_max;
    private String c_end; //강좌시작일
    
	public String getC_prod() {
		return c_prod;
	}
	public void setC_prod(String c_prod) {
		this.c_prod = c_prod;
	}
	public String getC_start() {
		return c_start;
	}
	public void setC_start(String c_start) {
		this.c_start = c_start;
	}
	public int getC_price() {
		return c_price;
	}
	public void setC_price(int c_price) {
		this.c_price = c_price;
	}
	public String getAp_no() {
		return ap_no;
	}
	public void setAp_no(String ap_no) {
		this.ap_no = ap_no;
	}
	public int getW_code() {
		return w_code;
	}
	public void setW_code(int w_code) {
		this.w_code = w_code;
	}
	public String getTc_name() {
		return tc_name;
	}
	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
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
	
	public String getP_sts() {
		return p_sts;
	}
	public void setP_sts(String p_sts) {
		this.p_sts = p_sts;
	}
	
	
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
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
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	
	public int getC_max() {
		return c_max;
	}
	public void setC_max(int c_max) {
		this.c_max = c_max;
	}
	public String getC_end() {
		return c_end;
	}
	public void setC_end(String c_end) {
		this.c_end = c_end;
	}
	
	
	public String getM_level() {
		return m_level;
	}
	public void setM_level(String m_level) {
		this.m_level = m_level;
	}
	
	public String getM_job() {
		return m_job;
	}
	public void setM_job(String m_job) {
		this.m_job = m_job;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	@Override
	public String toString() {
		return "ApplyDTO [ap_no=" + ap_no + ", w_code=" + w_code + ", tc_name=" + tc_name + ", ap_pay=" + ap_pay
				+ ", ap_date=" + ap_date + ", p_sts=" + p_sts + ", c_prod=" + c_prod + ", c_start=" + c_start
				+ ", c_price=" + c_price + ", p_no=" + p_no + ", m_id=" + m_id + ", m_name=" + m_name + ", m_job="
				+ m_job + ", m_email=" + m_email + ", m_level=" + m_level + ", m_phone=" + m_phone + ", c_max=" + c_max
				+ ", c_end=" + c_end + "]";
	}
	
    
}//class end
