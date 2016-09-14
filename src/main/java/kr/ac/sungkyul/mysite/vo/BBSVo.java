package kr.ac.sungkyul.mysite.vo;

public class BBSVo {
	private  Long no;
    private String title;
    private String content;
    private String regdate;
    
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "BBSVo [no=" + no + ", title=" + title + ", content=" + content + ", regdate=" + regdate + "]";
	}
}
