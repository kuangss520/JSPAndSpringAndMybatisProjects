package service;

import model.TUssrer;

public interface TUssrerService {
    int addUser(TUssrer record);
    boolean modifyUser(TUssrer record);
    boolean removeUser(String userAccount);
    TUssrer getUserByAccount(String userAccount);
    TUssrer login(String userAccount, String password);
}