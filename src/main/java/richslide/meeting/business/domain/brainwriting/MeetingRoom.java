package richslide.meeting.business.domain.brainwriting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MeetingRoom implements Serializable {
	private static final long serialVersionUID = 8996540540857192104L;
	
	public static final boolean PUBLIC_ROOM = false;
	public static final boolean PRIVATE_ROOM = true;
	
	public static final boolean COMPLETED_ROUND = true;
	
	private Session session;
	private String roomName;
	private User master;
	private List<User> contributors = new ArrayList<User> ();
	private boolean exposure;
	private String password;
	private boolean[] completionRound;
	
	public MeetingRoom(String roomName, User master, boolean exposure, String password) {
		this.roomName = roomName;
		this.master = master;
		this.exposure = exposure;
		this.password = password;
	}

	public Session getSession() {
		return session;
	}

	public String getRoomName() {
		return roomName;
	}

	public User getMaster() {
		return master;
	}

	public List<User> getContributors() {
		return contributors;
	}

	public boolean isExposure() {
		return exposure;
	}

	public String getPassword() {
		return password;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public void setMaster(User master) {
		this.master = master;
	}

	public void setContributors(List<User> contributors) {
		this.contributors = contributors;
	}

	public void setExposure(boolean exposure) {
		this.exposure = exposure;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean[] getCompletionRound() {
		return completionRound;
	}

	public void setCompletionRound(boolean[] completionRound) {
		this.completionRound = completionRound;
	}

	@Override
	public String toString() {
		return "MeetingRoom [session=" + session + ", roomName=" + roomName + ", master=" + master + ", contributors="
				+ contributors + ", exposure=" + exposure + ", password=" + password + "]";
	}
	
}
