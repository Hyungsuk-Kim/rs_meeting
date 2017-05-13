package richslide.meeting.business.domain.brainwriting;

import java.io.Serializable;

public class User implements Serializable, Comparable<User> {

	private static final long serialVersionUID = -6347822781778735996L;
	
	private int userId;
	private String userName;
	private String email;
	private String password;
	private int role;
	
	public static final int USER_ROLE = 0;
	public static final int SUPER_USER = 1;
	
	public User() {}
	
	public User(int userId, String userName, String email, String password, int role) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getRole() {
		return role;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", role=" + role + "]";
	}

	@Override
	public int compareTo(User o) {
		return this.userId - o.userId;
	}
	
}
