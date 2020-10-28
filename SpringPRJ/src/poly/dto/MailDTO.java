package poly.dto;

/**
 * @author 이협건
 * @version 1.1 공지사항 DTO
 */
public class MailDTO {

	String toMail;
	String title;
	String contents;

	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}