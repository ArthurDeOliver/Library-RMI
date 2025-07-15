import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;

public interface UserService extends Remote {
    void addUser(User user) throws RemoteException;
    User getUser(String username) throws RemoteException;
    List<User> getAllUsers() throws RemoteException;
}