package kr.co.academy.manager;

public class ManagerDTO {
	private String m_level;
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_job;
	private String m_email;
	private String email_agree;
	private String m_phone;
	private String phone_agree;
	private String ref_acount;
	private String ref_name;
	
	public ManagerDTO() {}
	public String getM_level() {
		return m_level;
	}
	public void setM_level(String m_level) {
		this.m_level = m_level;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_job() {
		return m_job;
	}
	public void setM_job(String m_job) {
		this.m_job = m_job;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getEmail_agree() {
		return email_agree;
	}
	public void setEmail_agree(String email_agree) {
		this.email_agree = email_agree;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getPhone_agree() {
		return phone_agree;
	}
	public void setPhone_agree(String phone_agree) {
		this.phone_agree = phone_agree;
	}
	public String getRef_acount() {
		return ref_acount;
	}
	public void setRef_acount(String ref_acount) {
		this.ref_acount = ref_acount;
	}
	public String getRef_name() {
		return ref_name;
	}
	public void setRef_name(String ref_name) {
		this.ref_name = ref_name;
	}
	@Override
	public String toString() {
		return "ManagerDTO [m_level=" + m_level + ", m_id=" + m_id + ", m_pw=" + m_pw + ", m_name=" + m_name
				+ ", m_job=" + m_job + ", m_email=" + m_email + ", email_agree=" + email_agree + ", m_phone=" + m_phone
				+ ", phone_agree=" + phone_agree + ", ref_acount=" + ref_acount + ", ref_name=" + ref_name + "]";
	}
	
	
}
