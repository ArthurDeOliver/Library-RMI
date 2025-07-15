package com.sd.project.common.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;

import com.sd.project.common.models.User;

public interface UserService extends Remote {
    void addUser(User user) throws RemoteException;
    User getUser(int id) throws RemoteException;
    List<User> getAllUsers() throws RemoteException;
}