package kr.co.academy.notice;

public class NoticeDTO {
	private String inform;
	private int n_no;
	private String n_subject;
	private String n_content; 
	private String m_id;
	private String n_date;
	private int n_readcnt;
	public NoticeDTO() {}
	public String getInform() {
		return inform;
	}
	public void setInform(String inform) {
		this.inform = inform;
	}
	public int getN_no() {
		return n_no;
	}
	public void setN_no(int n_no) {
		this.n_no = n_no;
	}
	public String getN_subject() {
		return n_subject;
	}
	public void setN_subject(String n_subject) {
		this.n_subject = n_subject;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getN_date() {
		return n_date;
	}
	public void setN_date(String n_date) {
		this.n_date = n_date;
	}
	public int getN_readcnt() {
		return n_readcnt;
	}
	public void setN_readcnt(int n_readcnt) {
		this.n_readcnt = n_readcnt;
	}
	@Override
	public String toString() {
		return "NoticeDTO [inform=" + inform + ", n_no=" + n_no + ", n_subject=" + n_subject + ", n_content="
				+ n_content + ", m_id=" + m_id + ", n_date=" + n_date + ", n_readcnt=" + n_readcnt + "]";
	}
	
}
