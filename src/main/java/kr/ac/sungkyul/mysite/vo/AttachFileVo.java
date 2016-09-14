package kr.ac.sungkyul.mysite.vo;

public class AttachFileVo {
	private Long fno;
	private Long no;
	private String path;
	private String orgName;
	private String saveName;
	private Long fileSize;
	
	public Long getFno() {
		return fno;
	}
	public void setFno(Long fno) {
		this.fno = fno;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	@Override
	public String toString() {
		return "AttachFileVo [fno=" + fno + ", no=" + no + ", path=" + path + ", orgName=" + orgName + ", saveName="
				+ saveName + ", fileSize=" + fileSize + "]";
	}
}