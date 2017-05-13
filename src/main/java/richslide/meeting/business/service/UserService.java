package richslide.meeting.business.service;

import java.util.List;
import java.util.Map;

import richslide.meeting.business.domain.brainwriting.User;
import richslide.meeting.exception.DataDuplicatedException;
import richslide.meeting.exception.DataNotFoundException;

public interface UserService {
	public User getUserByID(int userId) throws DataNotFoundException;
	public User getUserByEmail(String email) throws DataNotFoundException;
	public User getUserByName(String userName) throws DataNotFoundException;
	public List<User> getUserList(Map<String, Object> params);
	public void registerUser(User user) throws DataDuplicatedException;
	public void disableUser(int userId) throws DataNotFoundException;
	public void enableUser(int userId) throws DataNotFoundException;
	public void updateUser(User user) throws DataNotFoundException;
	public void deleteUser(int userId) throws DataNotFoundException;
}
