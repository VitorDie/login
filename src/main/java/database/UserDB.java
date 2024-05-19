package database;

import database.dataModel.User;

import java.util.ArrayList;

public interface UserDB {
    abstract void create(Integer id, User user);
    abstract User read(Integer id);
    abstract void update(Integer id, User user);
    abstract void delete(Integer id);
    public ArrayList<User> read();
}
