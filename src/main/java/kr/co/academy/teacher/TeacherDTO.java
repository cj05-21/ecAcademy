package kr.co.academy.teacher;

import org.springframework.web.multipart.MultipartFile;

public class TeacherDTO {
	private int tc_no;
	private String m_level;
	private String m_id;
	private String tc_name;
	private int w_code;
	private String c_code;
	private String poster;
	private String c_prod;
	private String m_email;
	private int max;
	
	
	//스프링 파일 객체 멤버변수
	private MultipartFile posterMF;

	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getM_level() {
		return m_level;
	}
	public void setM_level(String m_level) {
		this.m_level = m_level;
	}
	
	public int getTc_no() {
		return tc_no;
	}
	public void setTc_no(int tc_no) {
		this.tc_no = tc_no;
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
	
	public String getC_code() {
		return c_code;
	}
	public void setC_code(String c_code) {
		this.c_code = c_code;
	}
	
	public int getW_code() {
		return w_code;
	}
	public void setW_code(int w_code) {
		this.w_code = w_code;
	}
	public MultipartFile getPosterMF() {
		return posterMF;
	}
	public void setPosterMF(MultipartFile posterMF) {
		this.posterMF = posterMF;
	}
	
	
	public String getC_prod() {
		return c_prod;
	}
	public void setC_prod(String c_prod) {
		this.c_prod = c_prod;
	}
	
	
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	@Override
	public String toString() {
		return "TeacherDTO [tc_no=" + tc_no + ", m_level=" + m_level + ", m_id=" + m_id + ", tc_name=" + tc_name
				+ ", w_code=" + w_code + ", c_code=" + c_code + ", poster=" + poster + ", c_prod=" + c_prod
				+ ", m_email=" + m_email + ", max=" + max + ", posterMF=" + posterMF + "]";
	}
}//class() end	
