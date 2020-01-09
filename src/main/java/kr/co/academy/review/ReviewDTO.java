package kr.co.academy.review;

import org.springframework.web.multipart.MultipartFile;

public class ReviewDTO {
	private int r_no;         
	private String r_subject; 
	private String r_content;  
	private String m_id; 
	private String r_date;
	private String poster;  
	private int r_readcnt;
	private int score;
	private String c_code;
	//--------------------------------------------------
//	스프링 파일 객체 멤버변수
//	<intput type='file' name='posterMF'>	  
	  private MultipartFile posterMF;
//--------------------------------------------------
	
	public ReviewDTO() {}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_subject() {
		return r_subject;
	}

	public void setR_subject(String r_subject) {
		this.r_subject = r_subject;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getR_readcnt() {
		return r_readcnt;
	}

	public void setR_readcnt(int r_readcnt) {
		this.r_readcnt = r_readcnt;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public MultipartFile getPosterMF() {
		return posterMF;
	}

	public void setPosterMF(MultipartFile posterMF) {
		this.posterMF = posterMF;
	}

	@Override
	public String toString() {
		return "ReviewDTO [r_no=" + r_no + ", r_subject=" + r_subject + ", r_content=" + r_content + ", m_id=" + m_id
				+ ", r_date=" + r_date + ", poster=" + poster + ", r_readcnt=" + r_readcnt + ", score=" + score
				+ ", c_code=" + c_code + ", posterMF=" + posterMF + "]";
	}
	
	
	
	
}
