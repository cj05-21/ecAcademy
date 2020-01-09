package kr.co.academy.sogae;

import org.springframework.web.multipart.MultipartFile;

public class SogaeDTO{
private int img_code;
private String img_a;
private String img_b;           
private String img_c;           
private String img_d;         


private MultipartFile img_aIF;
private MultipartFile img_bIF;
private MultipartFile img_cIF;
private MultipartFile img_dIF;
public int getImg_code() {
	return img_code;
}
public void setImg_code(int img_code) {
	this.img_code = img_code;
}
public String getImg_a() {
	return img_a;
}
public void setImg_a(String img_a) {
	this.img_a = img_a;
}
public String getImg_b() {
	return img_b;
}
public void setImg_b(String img_b) {
	this.img_b = img_b;
}
public String getImg_c() {
	return img_c;
}
public void setImg_c(String img_c) {
	this.img_c = img_c;
}
public String getImg_d() {
	return img_d;
}
public void setImg_d(String img_d) {
	this.img_d = img_d;
}
public MultipartFile getImg_aIF() {
	return img_aIF;
}
public void setImg_aIF(MultipartFile img_aIF) {
	this.img_aIF = img_aIF;
}
public MultipartFile getImg_bIF() {
	return img_bIF;
}
public void setImg_bIF(MultipartFile img_bIF) {
	this.img_bIF = img_bIF;
}
public MultipartFile getImg_cIF() {
	return img_cIF;
}
public void setImg_cIF(MultipartFile img_cIF) {
	this.img_cIF = img_cIF;
}
public MultipartFile getImg_dIF() {
	return img_dIF;
}
public void setImg_dIF(MultipartFile img_dIF) {
	this.img_dIF = img_dIF;
}
@Override
public String toString() {
	return "SogaeDTO [img_code=" + img_code + ", img_a=" + img_a + ", img_b=" + img_b + ", img_c=" + img_c + ", img_d="
			+ img_d + ", img_aIF=" + img_aIF + ", img_bIF=" + img_bIF + ", img_cIF=" + img_cIF + ", img_dIF=" + img_dIF
			+ "]";
}














}//class end
