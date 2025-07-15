package com.sd.project.server;

import com.sd.project.common.models.User;

import com.sd.project.common.services.UserService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserImplementation extends UnicastRemoteObject implements UserService {

    private final HashMap<Integer, User> users = new HashMap<>();
    private int nextId = 1;

    public UserImplementation() throws RemoteException {
        super();
    }

    @Override
    public void addUser(User user) throws RemoteException {
        user.setUserId(nextId++);
        users.put(user.getUserId(), user);
    }

    @Override
    public User getUser(int id) throws RemoteException {
        return users.get(id);
    }

    @Override
    public List<User> getAllUsers() throws RemoteException {
        return new ArrayList<>(users.values());
    }
}