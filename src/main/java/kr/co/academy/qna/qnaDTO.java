package kr.co.academy.qna;

import java.util.Date;

public class qnaDTO {
	private int q_code; //질문자, 답변자 구분
	private int q_no; //질문 일련번호
	private String q_subject; //제목
	private String q_id; //작성자
	private String q_date; //작성일
	private int q_group; //QnA그룹번호
	private String q_content; //내용
	private int q_indent; //들여쓰기 카운트
	
	public int getQ_code() {
		return q_code;
	}
	public void setQ_code(int q_code) {
		this.q_code = q_code;
	}
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public String getQ_subject() {
		return q_subject;
	}
	public void setQ_subject(String q_subject) {
		this.q_subject = q_subject;
	}
	public String getQ_id() {
		return q_id;
	}
	public void setQ_id(String q_id) {
		this.q_id = q_id;
	}

	public int getQ_group() {
		return q_group;
	}
	public void setQ_group(int q_group) {
		this.q_group = q_group;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public int getQ_indent() {
		return q_indent;
	}
	public void setQ_indent(int q_indent) {
		this.q_indent = q_indent;
	}
	public String getQ_date() {
		return q_date;
	}
	public void setQ_date(String q_date) {
		this.q_date = q_date;
	}
	@Override
	public String toString() {
		return "qnaDTO [q_code=" + q_code + ", q_no=" + q_no + ", q_subject=" + q_subject + ", q_id=" + q_id
				+ ", q_date=" + q_date + ", q_group=" + q_group + ", q_content=" + q_content + ", q_indent=" + q_indent
				+ "]";
	}

	
	
}