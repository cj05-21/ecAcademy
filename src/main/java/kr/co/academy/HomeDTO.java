package kr.co.academy;

public class HomeDTO {

	 private int r_readcnt;
	 private String r_subject;
	 private String r_content;
	 private String m_id;
	 private String poster;
	 private String r_date;
	 private int score;
	 private String c_code;
	 private int rownum;
	
	 	private int w_code;
		private String c_prod;
		private String c_det;
		private String c_book;
		private int c_price;
		private String c_image;
		private int c_max;
		private String c_date;
		private String c_datend;
		private String c_start;
		private String c_end;
		private String tc_name;
		
		
		public HomeDTO() {}
		public int getR_readcnt() {
			return r_readcnt;
		}
		public void setR_readcnt(int r_readcnt) {
			this.r_readcnt = r_readcnt;
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
		public String getPoster() {
			return poster;
		}
		public void setPoster(String poster) {
			this.poster = poster;
		}
		public String getR_date() {
			return r_date;
		}
		public void setR_date(String r_date) {
			this.r_date = r_date;
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
		public int getRownum() {
			return rownum;
		}
		public void setRownum(int rownum) {
			this.rownum = rownum;
		}
		public int getW_code() {
			return w_code;
		}
		public void setW_code(int w_code) {
			this.w_code = w_code;
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
		public String getTc_name() {
			return tc_name;
		}
		public void setTc_name(String tc_name) {
			this.tc_name = tc_name;
		}
		@Override
		public String toString() {
			return "HomeDTO [r_readcnt=" + r_readcnt + ", r_subject=" + r_subject + ", r_content=" + r_content
					+ ", m_id=" + m_id + ", poster=" + poster + ", r_date=" + r_date + ", score=" + score + ", c_code="
					+ c_code + ", rownum=" + rownum + ", w_code=" + w_code + ", c_prod=" + c_prod + ", c_det=" + c_det
					+ ", c_book=" + c_book + ", c_price=" + c_price + ", c_image=" + c_image + ", c_max=" + c_max
					+ ", c_date=" + c_date + ", c_datend=" + c_datend + ", c_start=" + c_start + ", c_end=" + c_end
					+ ", tc_name=" + tc_name + "]";
		}
	
}
