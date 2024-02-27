package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService user = new UserServiceImpl();
        user.createUsersTable();
        user.saveUser("Андрей", "Прор", (byte) 2);
        user.saveUser("Анд", "Про33р", (byte) 5);
        user.saveUser("Андре3232й", "Про2332р", (byte) 8);
        user.saveUser("Андwqrqwrqрей", "Пqweqрор", (byte) 1);
        user.getAllUsers().forEach(System.out::println);
        user.cleanUsersTable();
        user.dropUsersTable();




    }
}
