package model.tools;

import model.entities.User;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by R-Tem on 01.06.2015.
 */
public class UsersUtil {

    private static FileUtil<User> fileUtil;

    public static Boolean registration (String userName, String password) throws FileNotFoundException {
        Boolean registed = false;
        ArrayList<User> users = fileUtil.readObjFromFile("src/main/resources/data/users.data.ser");
        User newUser = new User(userName, password);
        users.add(newUser);
        new FileUtil().writeObjToFile(users, "src/main/resources/data/users.data.ser");
        return registed;
    }

    public static Boolean authorization(String userName, String password) throws FileNotFoundException {
        Boolean isAuthorised = false;
        ArrayList<User> users = fileUtil.readObjFromFile("src/main/resources/data/users.data.ser");
        User user;
        for (int i = 0; i < users.size(); i++) {
            user = users.get(i);
            if (userName.equals(user.getUserName()) && password.equals(user.getPassword())){
                isAuthorised = true;
            }
        }
        return isAuthorised;
    }
}
