package kr.co.academy.wish;

public class WishDTO {
    private int wlist;
    private int w_code; 
    private String m_id;
    private String c_prod;
    private int c_price;
    private String c_start;
    private String tc_name;
    
	public String getTc_name() {
		return tc_name;
	}
	public void setTc_name(String tc_name) {
		this.tc_name = tc_name;
	}
	public String getC_start() {
		return c_start;
	}
	public void setC_start(String c_start) {
		this.c_start = c_start;
	}
	public int getWlist() {
		return wlist;
	}
	public void setWlist(int wlist) {
		this.wlist = wlist;
	}
	public int getW_code() {
		return w_code;
	}
	public void setW_code(int w_code) {
		this.w_code = w_code;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getC_prod() {
		return c_prod;
	}
	public void setC_prod(String c_prod) {
		this.c_prod = c_prod;
	}
	public int getC_price() {
		return c_price;
	}
	public void setC_price(int c_price) {
		this.c_price = c_price;
	}
	@Override
	public String toString() {
		return "WishDTO [wlist=" + wlist + ", w_code=" + w_code + ", m_id=" + m_id + ", c_prod=" + c_prod + ", c_price="
				+ c_price + ", c_start=" + c_start + ", tc_name=" + tc_name + "]";
	}
	
    
    
}//class end
