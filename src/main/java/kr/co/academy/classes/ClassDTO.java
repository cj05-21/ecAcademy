package kr.co.academy.classes;

import org.springframework.web.multipart.MultipartFile;

public class ClassDTO {
	private int w_code;
	private String c_code;
	private String c_prod;
	private String c_det;
	private String c_book;
	private int c_price;
	private String c_image;
	private int c_max;
	private String c_test;
	private String c_date;
	private String c_datend;
	private String c_start;
	private String c_end;
	private String tc_name;
	private String poster;
	private int r;
	
//스프링 파일 객체 멤버변수

	
	public String getTc_name() {
		return tc_name;
	}

	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}

	private MultipartFile c_imageIF;

	private MultipartFile c_detIF;

	public int getW_code() {
		return w_code;
	}

	public void setW_code(int w_code) {
		this.w_code = w_code;
	}

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getC_prod() {
		return c_prod;
	}

	public void setC_prod(String c_prod) {
		this.c_prod = c_prod;
	}

	public String getC_det() {
		return c_det;
	}

	public void setC_det(String c_det) {
		this.c_det = c_det;
	}

	public String getC_book() {
		return c_book;
	}

	public void setC_book(String c_book) {
		this.c_book = c_book;
	}

	public int getC_price() {
		return c_price;
	}

	public void setC_price(int c_price) {
		this.c_price = c_price;
	}

	public String getC_image() {
		return c_image;
	}

	public void setC_image(String c_image) {
		this.c_image = c_image;
	}

	public int getC_max() {
		return c_max;
	}

	public void setC_max(int c_max) {
		this.c_max = c_max;
	}

	public String getC_test() {
		return c_test;
	}

	public void setC_test(String c_test) {
		this.c_test = c_test;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public String getC_datend() {
		return c_datend;
	}

	public void setC_datend(String c_datend) {
		this.c_datend = c_datend;
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

	public MultipartFile getC_imageIF() {
		return c_imageIF;
	}

	public void setC_imageIF(MultipartFile c_imageIF) {
		this.c_imageIF = c_imageIF;
	}

	public MultipartFile getC_detIF() {
		return c_detIF;
	}

	public void setC_detIF(MultipartFile c_detIF) {
		this.c_detIF = c_detIF;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	@Override
	public String toString() {
		return "ClassDTO [w_code=" + w_code + ", c_code=" + c_code + ", c_prod=" + c_prod + ", c_det=" + c_det
				+ ", c_book=" + c_book + ", c_price=" + c_price + ", c_image=" + c_image + ", c_max=" + c_max
				+ ", c_test=" + c_test + ", c_date=" + c_date + ", c_datend=" + c_datend + ", c_start=" + c_start
				+ ", c_end=" + c_end + ", tc_name=" + tc_name + ", poster=" + poster + ", r=" + r + ", c_imageIF="
				+ c_imageIF + ", c_detIF=" + c_detIF + "]";
	}


}// class end
