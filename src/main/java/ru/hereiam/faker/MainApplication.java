package ru.hereiam.faker;

import ru.hereiam.faker.dao.UserDao;
import ru.hereiam.faker.dao.jdbc.MssqlDao;
import ru.hereiam.faker.generators.User;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<User> users= new ArrayList<>();
        System.out.println("I am main application");
        int count = 15550;
        for (int i=0;i<count;i++){
        users.add(new User.Builder().login().firstName()
                                        .lastName()
                                        .age(18,55)
                                        .streetAddress()
                                        .password("[A-Z]{5}[0-9]{3,4}[a-z]{2,7}[-{/&^%$@#(*]{1,4}").build());
        }





        UserDao userDao = new MssqlDao();
        userDao.connect();
        userDao.setUsers(users);

    }
}
