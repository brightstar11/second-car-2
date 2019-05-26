package com.xh.entity;

public class News {
	 private Integer id;
	    private String newsytpe;
	    private String title;
	    private String time;
	    private String autor;
	    private String pone;
	    private String context;
	    private String ptwo;
	    private String image1;
	    private String pthree;
	    private String image2;
	    private String pfour;
	    private String image3;
	    private String pfive;
	    private String image4;
	    private Integer heat;
	    
		public Integer getHeat() {
			return heat;
		}
		public void setHeat(Integer heat) {
			this.heat = heat;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNewsytpe() {
			return newsytpe;
		}
		public void setNewsytpe(String newsytpe) {
			this.newsytpe = newsytpe;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getAutor() {
			return autor;
		}
		public void setAutor(String autor) {
			this.autor = autor;
		}
		public String getPone() {
			return pone;
		}
		public void setPone(String pone) {
			this.pone = pone;
		}
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		public String getPtwo() {
			return ptwo;
		}
		public void setPtwo(String ptwo) {
			this.ptwo = ptwo;
		}
		public String getImage1() {
			return image1;
		}
		public void setImage1(String image1) {
			this.image1 = image1;
		}
		public String getPthree() {
			return pthree;
		}
		public void setPthree(String pthree) {
			this.pthree = pthree;
		}
		public String getImage2() {
			return image2;
		}
		public void setImage2(String image2) {
			this.image2 = image2;
		}
		public String getPfour() {
			return pfour;
		}
		public void setPfour(String pfour) {
			this.pfour = pfour;
		}
		public String getImage3() {
			return image3;
		}
		public void setImage3(String image3) {
			this.image3 = image3;
		}
		public String getPfive() {
			return pfive;
		}
		public void setPfive(String pfive) {
			this.pfive = pfive;
		}
		public String getImage4() {
			return image4;
		}
		public void setImage4(String image4) {
			this.image4 = image4;
		}
		@Override
		public String toString() {
			return "News [id=" + id + ", typeid=" + newsytpe + ", title=" + title + ", time=" + time + ", autor=" + autor
					+ ", pone=" + pone + ", context=" + context + ", ptwo=" + ptwo + ", image1=" + image1 + ", pthree="
					+ pthree + ", image2=" + image2 + ", pfour=" + pfour + ", image3=" + image3 + ", pfive=" + pfive
					+ ", image4=" + image4 + "]";
		}
	    
}