package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection;

    public UserDaoJDBCImpl() {
        connection = Util.getJDBCConnection();
    }

    public void createUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("""
                    create table if not exists users(
                    id serial,
                    firstname varchar(100) not NULL,
                    lastname varchar(100) not NULL,
                    age int not NULL);
                    """);

        } catch (SQLException e) {
            System.out.println("Ошибка в создании таблицы");;
        }

    }

    public void dropUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("""
                    drop table users
                    """);
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении таблицы");;
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                    insert into users (firstname,lastname,age) 
                    values (?,?,?)
                    """);
            {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, lastName);
                preparedStatement.setByte(3, age);

            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении User");;
        }
    }

    public void removeUserById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                    delete from users
                    where id=?
                    """);

            {
                preparedStatement.setLong(1, id);
            }
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ошибка при удалении User");;
        }

    }

    public List<User> getAllUsers() {
        List<User> list1 = new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            ResultSet set1 = statement.executeQuery("""
                    select*from users
                    """);
            while (set1.next()) {
                list1.add(new User(
                        set1.getLong(1),
                        set1.getString(2),
                        set1.getString(3),
                        set1.getByte(4)));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении таблицы");;
        }
        return list1;
    }

    public void cleanUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("""
TRUNCATE TABLE users
""");
        } catch (SQLException e) {
            System.out.println("Ошибка при очистке таблицы");;
        }

    }
}
