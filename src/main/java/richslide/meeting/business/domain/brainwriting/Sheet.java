package richslide.meeting.business.domain.brainwriting;

import java.io.Serializable;
import java.util.List;

public class Sheet implements Serializable {

	private static final long serialVersionUID = -5204467910081433406L;
	
	private Session currSession;
	private String sheetId; // 
	private User owner;
	private List<Idea[]> ideaGrid;
	private List<Idea> ideaSetPerPerson;
	private int currRound;
	
	public static final String SHEET_ID_DELIMITER = ".";
	
	public Sheet() {}
	
	public Sheet(Session currSession ,User owner) {
		this.owner = owner;
		this.sheetId = currSession.getSessionId() + SHEET_ID_DELIMITER + owner.getUserId();
	}
	
	public Sheet(String sheetId, User owner, List<Idea[]> ideaGrid) {
		this.sheetId = sheetId;
		this.owner = owner;
		this.ideaGrid =ideaGrid;
		this.currRound = this.ideaGrid.size();
	}

	public Session getCurrSession() {
		return currSession;
	}

	public String getSheetId() {
		return sheetId;
	}

	public User getOwner() {
		return owner;
	}

	public List<Idea[]> getIdeaGrid() {
		return ideaGrid;
	}

	public List<Idea> getIdeaSetPerPerson() {
		return ideaSetPerPerson;
	}

	public int getCurrRound() {
		return currRound;
	}

	public void setCurrSession(Session currSession) {
		this.currSession = currSession;
	}

	public void setSheetId(String sheetId) {
		this.sheetId = sheetId;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setIdeaGrid(List<Idea[]> ideaGrid) {
		this.ideaGrid = ideaGrid;
	}

	public void setIdeaSetPerPerson(List<Idea> ideaSetPerPerson) {
		this.ideaSetPerPerson = ideaSetPerPerson;
	}

	public void setCurrRound(int currRound) {
		this.currRound = currRound;
	}

	@Override
	public String toString() {
		return "Sheet [currSession=" + currSession + ", sheetId=" + sheetId + ", owner=" + owner + ", ideaGrid="
				+ ideaGrid + ", ideaSetPerPerson=" + ideaSetPerPerson + ", currRound=" + currRound + "]";
	}
	
}
