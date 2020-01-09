package kr.co.academy.attend;

public class AttendDTO {
	private int att_no;         
	private String m_id;         
	private String tc_name;    
	private int w_code;        
	private String attend_date;
	
	private String m_name;
	private String c_prod;
	private String c_start;                       
	private String c_end;
	
	private int ap_no;
	private String p_sts;
	
	private String m_level;
    private String m_email;
    private String m_job;
    private String m_phone;
	
	
	
	public AttendDTO() {}
	public int getAtt_no() {
		return att_no;
	}
	public void setAtt_no(int att_no) {
		this.att_no = att_no;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getTc_name() {
		return tc_name;
	}
	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}
	public int getW_code() {
		return w_code;
	}
	public void setW_code(int w_code) {
		this.w_code = w_code;
	}
	public String getAttend_date() {
		return attend_date;
	}
	public void setAttend_date(String attend_date) {
		this.attend_date = attend_date;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
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
	public String getC_end() {
		return c_end;
	}
	public void setC_end(String c_end) {
		this.c_end = c_end;
	}
	public int getAp_no() {
		return ap_no;
	}
	public void setAp_no(int ap_no) {
		this.ap_no = ap_no;
	}
	public String getP_sts() {
		return p_sts;
	}
	public void setP_sts(String p_sts) {
		this.p_sts = p_sts;
	}
	
	public String getM_level() {
		return m_level;
	}
	public void setM_level(String m_level) {
		this.m_level = m_level;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
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
		return "AttendDTO [att_no=" + att_no + ", m_id=" + m_id + ", tc_name=" + tc_name + ", w_code=" + w_code
				+ ", attend_date=" + attend_date + ", m_name=" + m_name + ", c_prod=" + c_prod + ", c_start=" + c_start
				+ ", c_end=" + c_end + ", ap_no=" + ap_no + ", p_sts=" + p_sts + ", m_level=" + m_level + ", m_email="
				+ m_email + ", m_job=" + m_job + ", m_phone=" + m_phone + "]";
	}
	
	                      
}
