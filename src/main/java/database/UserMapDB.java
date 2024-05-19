package database;

import database.dataModel.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapDB implements UserDB {
    protected UserMapDB() {}
    static UserMapDB instance = null;
    private static Integer validId = 0;

    public static UserMapDB getInstance() {
        if (instance == null)
        {
            instance = new UserMapDB();
        }
        return instance;
    }


    Map<Integer, User> database = new HashMap<>();

    @Override
    public void create(Integer id, User user) {
        database.put(id, user);
        validId = id;
    }

    @Override
    public User read(Integer id) {
        return database.get(id);
    }

    @Override
    public void update(Integer id, User user) {
        database.replace(id, user);
    }

    @Override
    public void delete(Integer id) {
        database.remove(id);
    }

    public ArrayList<User> read() {
        ArrayList<User> lista = new ArrayList<>();
        for (Integer key : database.keySet())
        {
            lista.add(database.get(key));
        }
        return lista;
    }

    public static Integer getValidId() {
        return validId;
    }
}
