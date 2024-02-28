package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService user = new UserServiceImpl();
//        user.createUsersTable();
//         user.saveUser("Андрей", "Прорweqw", (byte) 2);
//         user.saveUser("Андрей", "Прорweqw", (byte) 2);
//         user.saveUser("Андрей", "Прорweqw", (byte) 2);
//         user.saveUser("Андрей", "Прорweqw", (byte) 2);

//         user.removeUserById(2);
//         user.removeUserById(3);
//         user.removeUserById(4);

//      user.getAllUsers().forEach(System.out::println);
        user.cleanUsersTable();
//        user.dropUsersTable();




    }
}
