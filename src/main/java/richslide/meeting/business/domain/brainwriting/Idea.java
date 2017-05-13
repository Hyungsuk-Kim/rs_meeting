package richslide.meeting.business.domain.brainwriting;

import java.io.Serializable;

public class Idea implements Serializable {

	private static final long serialVersionUID = 7884544996437005543L;

	private int ideaId;
	private String content;
	private User author;
	
	public Idea() {
		
	}
	
	public Idea(String content, User author) {
		this.content = content;
		this.author = author;
	}
	
	public Idea(int ideaId, String content, User author) {
		this(content, author);
		this.ideaId = ideaId;
	}

	public int getIdeaId() {
		return ideaId;
	}

	public String getContent() {
		return content;
	}

	public User getAuthor() {
		return author;
	}

	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Idea [ideaId=" + ideaId + ", content=" + content + ", author=" + author + "]";
	}
	
}
