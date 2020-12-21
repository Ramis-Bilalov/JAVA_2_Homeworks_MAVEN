package Lesson8;

import java.util.HashMap;

public class MockAuthServiceImpl implements AuthService {

    private static MockAuthServiceImpl instance;
    private HashMap<String, String> userDao;

    private MockAuthServiceImpl() {
        userDao = new HashMap<>();
        userDao.put("user", "pass");
    }

    public HashMap<String, String> getUserDao() {
        return userDao;
    }

    public static MockAuthServiceImpl getInstance() {
        if (instance == null) {
            instance = new MockAuthServiceImpl();
        }
        return instance;
    }

    @Override
    public void addUser(String name, String pass) {
        userDao.put(name, pass);
    }

    @Override
    public boolean auth(String name, String pass) {
        return userDao.containsKey(name) && userDao.containsValue(pass);
    }
}
