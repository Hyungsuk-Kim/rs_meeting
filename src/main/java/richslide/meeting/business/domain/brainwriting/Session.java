package richslide.meeting.business.domain.brainwriting;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Session implements Serializable {

	private static final long serialVersionUID = 7959554794021511714L;
	
	private int sessionId;
	private User master;
	private String subject;
	private List<Sheet> sheets;
	private List<User> contributors;
	private Timestamp startTime;
	private Timestamp endTime;
	private int round;
	private int suggestionCount;
	private long timePerRound;
	private int exposure;
	
	public static final int PUBLIC_SESSION = 0;
	public static final int PRIVATE_SESSION = 1;
	
	public Session() {
		
	}
	
	public Session(User master, String subject, Timestamp startTime, Timestamp endTime, int suggestionCountPerPerson, long timePerRound, int exposure, User... users) {
		this.master = master;
		this.subject = subject;
		this.startTime = startTime;
		this.endTime = endTime;
		this.suggestionCount = suggestionCountPerPerson;
		this.timePerRound = timePerRound;
		this.exposure = exposure;
		
		if (users != null && users.length > 0) {
			this.round = users.length;
			this.contributors = new ArrayList<User>();
			for (User user : users) {
				this.contributors.add(user);
			}
		}
	}
	
	public Session(User master, String subject, int suggestionCountPerPerson, long timePerRound, int exposure) {
		this(master, subject, new Timestamp(System.currentTimeMillis()), null, suggestionCountPerPerson, timePerRound, exposure, master);
	}
	
	public Session(int sessionId, User master, String subject, Timestamp startTime, Timestamp endTime, int suggestionCountPerPerson, long timePerRound, int exposure, Sheet[] sheets, User[] contributors) {
		this(master, subject, startTime, endTime, suggestionCountPerPerson, timePerRound, exposure, contributors);
		this.sessionId = sessionId;
		
		if (sheets != null && sheets.length > 0) {
			for (Sheet sheet : sheets) {
				this.sheets = new ArrayList<Sheet>();
				this.sheets.add(sheet);
			}
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getSessionId() {
		return sessionId;
	}

	public User getMaster() {
		return master;
	}

	public String getSubject() {
		return subject;
	}

	public List<Sheet> getSheets() {
		return sheets;
	}

	public List<User> getContributors() {
		return contributors;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public int getRound() {
		return round;
	}

	public int getSuggestionCount() {
		return suggestionCount;
	}

	public long getTimePerRound() {
		return timePerRound;
	}

	public int getExposure() {
		return exposure;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public void setMaster(User master) {
		this.master = master;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setSheets(List<Sheet> sheets) {
		this.sheets = sheets;
	}

	public void setContributors(List<User> contributors) {
		this.contributors = contributors;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public void setSuggestionCount(int suggestionCount) {
		this.suggestionCount = suggestionCount;
	}

	public void setTimePerRound(long timePerRound) {
		this.timePerRound = timePerRound;
	}

	public void setExposure(int exposure) {
		this.exposure = exposure;
	}

	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", master=" + master + ", subject=" + subject + ", sheets=" + sheets
				+ ", contributors=" + contributors + ", startTime=" + startTime + ", endTime=" + endTime + ", round="
				+ round + ", suggestionCount=" + suggestionCount + ", timePerRound=" + timePerRound + ", exposure="
				+ exposure + "]";
	}
	
}
