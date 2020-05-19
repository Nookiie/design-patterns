import java.util.ArrayList;

public interface IChatRoom {
	void sendMessage(String message, User user);

	void addUser(User user);

	void addBot(String botName);
	
	ArrayList<User> getUsers();

	void putUserInBanList(User user);
}
